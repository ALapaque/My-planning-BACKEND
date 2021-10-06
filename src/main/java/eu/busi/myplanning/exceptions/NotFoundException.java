package eu.busi.myplanning.exceptions;

/**
 * The type Not found exception.
 */
public class NotFoundException extends ResponseEntityException {
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Not found exception.
     */
    public NotFoundException() {
        super("An error occured while trying to find the ressource");
    }
}
