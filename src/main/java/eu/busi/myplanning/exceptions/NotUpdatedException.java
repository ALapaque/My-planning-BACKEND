package eu.busi.myplanning.exceptions;

/**
 * The type Not updated exception.
 */
public class NotUpdatedException extends ResponseEntityException {
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Not updated exception.
     */
    public NotUpdatedException() {
        super("An error occured while trrying to update the ressource");
    }
}
