package eu.busi.myplanning.payload;

/**
 * payload for the login response
 */
public class JwtAuthenticationResponse {
    private String token;

    /**
     * Instantiates a new Jwt authentication response.
     *
     * @param token the token
     */
    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
