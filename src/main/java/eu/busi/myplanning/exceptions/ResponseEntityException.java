package eu.busi.myplanning.exceptions;

public class ResponseEntityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResponseEntityException(String message) {
        super(message);
    }

}
