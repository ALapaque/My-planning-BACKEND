package eu.busi.myplanning.exceptions;

public class NotFoundException extends ResponseEntityException {
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("An error occured while trying to find the ressource");
    }
}
