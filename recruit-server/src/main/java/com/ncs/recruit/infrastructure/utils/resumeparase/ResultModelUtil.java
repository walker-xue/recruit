package com.ncs.recruit.infrastructure.utils.resumeparase;

public class ResultModelUtil<T> {

    private boolean isSuccess = true;
    private String erroCode;
    private String message;
    private T data;
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    public String getErroCode() {
        return erroCode;
    }
    public void setErroCode(String erroCode) {
        this.erroCode = erroCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

}
