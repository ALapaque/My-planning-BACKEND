package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.services.impl.AuthService;
import eu.busi.myplanning.domain.services.impl.MyUserDetailService;
import eu.busi.myplanning.payload.JwtAuthenticationRequest;
import eu.busi.myplanning.payload.JwtAuthenticationResponse;
import eu.busi.myplanning.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthControllerImpl {
    private final AuthenticationManager _authenticationManager;
    private final AuthService _authService;
    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtils;

    public AuthControllerImpl(AuthenticationManager _authenticationManager, AuthService _authService, MyUserDetailService _myUserDetailService, JwtUtil _jwtUtils) {
        this._authenticationManager = _authenticationManager;
        this._authService = _authService;
        this.myUserDetailService = _myUserDetailService;
        this.jwtUtils = _jwtUtils;
    }

    /**
     * Login through a POST
     *
     * @param jwtAuthenticationRequest the jwt authentication request
     * @return the response entity
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) {
        ResponseEntity<?> _responseEntity;

        try {
            _authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtAuthenticationRequest.getUsernameOrEmail(),
                            jwtAuthenticationRequest.getPassword()
                    )
            );

            final UserDetails userDetails = myUserDetailService.loadUserByUsername(jwtAuthenticationRequest.getUsernameOrEmail());
            final String jwt = jwtUtils.generateToken(userDetails);

            _responseEntity = new ResponseEntity<>(new JwtAuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException | JsonProcessingException e) {
            _responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return _responseEntity;
    }

    /**
     * REGISTER through a POST
     *
     * @return the response entity
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        ResponseEntity<?> _responseEntity;

        try {
            _responseEntity = new ResponseEntity<Object>(UserMapper.INSTANCE.asDTO(_authService.register(user)), HttpStatus.CREATED);
        } catch (Exception e) {
            _responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return _responseEntity;
    }
}
