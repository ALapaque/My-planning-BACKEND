package eu.busi.myplanning.exceptions;

/**
 * The type Not deleted exception.
 */
public class NotDeletedException extends ResponseEntityException {
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Not deleted exception.
     */
    public NotDeletedException() {
        super("An error occured while trying to delete the ressource");
    }

}
