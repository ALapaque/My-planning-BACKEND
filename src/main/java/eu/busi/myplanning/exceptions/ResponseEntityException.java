package eu.busi.myplanning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityException extends RuntimeException {

    public ResponseEntityException(String message) {
        super(message);
    }

    public ResponseEntity<?> getResponseEntity() {
        return new ResponseEntity<>(super.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
