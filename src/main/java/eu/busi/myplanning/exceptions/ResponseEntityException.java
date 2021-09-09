package eu.busi.myplanning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResponseEntityException(String message) {
        super(message);
    }

    public ResponseEntity<Object> responseEntity() {
        ApiError error = new ApiError(super.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
