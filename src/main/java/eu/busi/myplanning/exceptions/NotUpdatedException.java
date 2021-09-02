package eu.busi.myplanning.exceptions;

public class NotUpdatedException extends ResponseEntityException {
    private static final long serialVersionUID = 1L;

    public NotUpdatedException() {
        super("An error occured while trrying to update the ressource");
    }
}
