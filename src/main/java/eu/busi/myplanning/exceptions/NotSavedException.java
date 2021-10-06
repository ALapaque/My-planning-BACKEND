package eu.busi.myplanning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The type Not saved exception.
 */
public class NotSavedException extends ResponseEntityException {
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Not saved exception.
     */
    public NotSavedException() {
        super("An error occured while trying to save the ressource");
    }
}
