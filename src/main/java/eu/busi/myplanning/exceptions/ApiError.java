package eu.busi.myplanning.exceptions;

import org.springframework.http.HttpStatus;

public class ApiError {
    private String message;
    private int code;
    private HttpStatus httpStatus;

    public ApiError(String message,  HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.code = httpStatus.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
