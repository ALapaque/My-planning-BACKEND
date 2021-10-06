package eu.busi.myplanning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The type Response entity exception.
 */
public class ResponseEntityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Response entity exception.
     *
     * @param message the message
     */
    public ResponseEntityException(String message) {
        super(message);
    }

    /**
     * Response entity response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> responseEntity() {
        ApiError error = new ApiError(super.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
