package eu.busi.myplanning.payload;

/**
 * Payload for the login request
 */
public class JwtAuthenticationRequest {
    private String usernameOrEmail;
    private String password;


    /**
     * Gets username or email.
     *
     * @return the username or email
     */
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    /**
     * Sets username or email.
     *
     * @param usernameOrEmail the username or email
     */
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
