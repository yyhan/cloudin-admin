package com.cloudin.admin.web.lang;

/**
 * Created by YFHan on 2017/1/3 0003.
 */
public class BaseResponse {

    private boolean success;
    private Object data;
    private String message;
    private Exception exception;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public void markSuccess() {
        this.success = true;
    }


    public void markSuccess(Object data) {
        this.success = true;
        this.data = data;
    }

    public void markError() {
        this.success = false;
    }

    public void markError(String message) {
        this.success = false;
        this.message = message;
    }

    public void markException(Exception exception){
        markError(exception.getMessage());
        this.exception = exception;
    }

    public void markException(String message, Exception exception){
        markError(message);
        this.exception = exception;
    }
}