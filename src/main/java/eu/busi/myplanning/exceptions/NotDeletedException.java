package eu.busi.myplanning.exceptions;

public class NotDeletedException extends ResponseEntityException {
    private static final long serialVersionUID = 1L;

    public NotDeletedException() {
        super("An error occured while trying to delete the ressource");
    }

}
