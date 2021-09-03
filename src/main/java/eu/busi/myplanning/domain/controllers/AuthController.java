package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.domain.api.AuthApi;
import eu.busi.myplanning.domain.dto.JwtAuthenticationRequest;
import eu.busi.myplanning.domain.dto.UserDTO;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.services.impl.AuthService;
import eu.busi.myplanning.domain.services.impl.MyUserDetailService;
import eu.busi.myplanning.payload.JwtAuthenticationResponse;
import eu.busi.myplanning.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Auth controller.
 */
@RestController
public class AuthController implements AuthApi {
    private final AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtils;

    public AuthController(AuthService _authService, MyUserDetailService _myUserDetailService, JwtUtil _jwtUtils) {
        this.authService = _authService;
        this.myUserDetailService = _myUserDetailService;
        this.jwtUtils = _jwtUtils;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Object> authenticateUser(JwtAuthenticationRequest body) {
        ResponseEntity<Object> _responseEntity;

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            body.getUsernameOrEmail(),
                            body.getPassword()
                    )
            );

            final UserDetails userDetails = myUserDetailService.loadUserByUsername(body.getUsernameOrEmail());
            final String jwt = jwtUtils.generateToken(userDetails);

            _responseEntity = new ResponseEntity<>(new JwtAuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException | JsonProcessingException e) {
            _responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return _responseEntity;
    }

    @Override
    public ResponseEntity<Object> register(UserDTO body) {
        ResponseEntity<Object> _responseEntity;

        try {
            _responseEntity = new ResponseEntity<Object>(
                    UserMapper.INSTANCE.asDTO(authService.register(UserMapper.INSTANCE.fromDtoToEntity(body))),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            _responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return _responseEntity;
    }
}
