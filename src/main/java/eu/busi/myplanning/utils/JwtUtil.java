package eu.busi.myplanning.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.models.UserDTO;
import eu.busi.myplanning.api.models.UserLightDTO;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * JwtUtil service
 */
@Service
public class JwtUtil {
    private final UserRepository _userRepository;

    /**
     * secret key of the token
     */
    private final String SECRET_KEY = "secret";
    private final ObjectMapper objectMapper;

    /**
     * Instantiates a new Jwt util.
     *
     * @param _userRepository the user repository
     * @param objectMapper    the object mapper
     */
    public JwtUtil(UserRepository _userRepository, ObjectMapper objectMapper) {
        this._userRepository = _userRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * this method will extract the username contained in the token
     *
     * @param token the token
     * @return string
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * this method will extract the expiration date contained in the token
     *
     * @param token the token
     * @return date
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * this method will extract the claimer contained in the token
     *
     * @param <T>            the type parameter
     * @param token          the token
     * @param claimsResolver the claims resolver
     * @return t
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * this method will check if the token is valid
     *
     * @param token       the token
     * @param userDetails the user details
     * @return boolean
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        return (extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * this method will generate a token
     *
     * @param userDetails the user details
     * @return string
     * @throws JsonProcessingException the json processing exception
     */
    public String generateToken(UserDetails userDetails) throws JsonProcessingException {
        Map<String, Object> claims = new HashMap<>();
        Optional<UserEntity> user = _userRepository.findByUsername(userDetails.getUsername());

        if (user.isPresent()) {
            UserLightDTO userDTO = UserMapper.INSTANCE.asLightDto(user.get());
            claims.put("user", this.objectMapper.writeValueAsString(userDTO));
            claims.put("authorities", userDTO.getRole().getAuthorities().toArray());
        }

        return createToken(claims, userDetails.getUsername());
    }

    /**
     * this method will extract all claims
     *
     * @param token
     * @return
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    /**
     * this method will check if the token is expired
     *
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * this method will create a token with a signature
     *
     * @param claims
     * @param subject
     * @return
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}
