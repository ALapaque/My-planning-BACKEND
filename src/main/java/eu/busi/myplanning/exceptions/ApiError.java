package eu.busi.myplanning.exceptions;

import org.springframework.http.HttpStatus;

/**
 * The type Api error.
 */
public class ApiError {
    private String message;
    private int code;
    private HttpStatus httpStatus;

    /**
     * Instantiates a new Api error.
     *
     * @param message    the message
     * @param httpStatus the http status
     */
    public ApiError(String message,  HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.code = httpStatus.value();
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets http status.
     *
     * @return the http status
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Sets http status.
     *
     * @param httpStatus the http status
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }
}
