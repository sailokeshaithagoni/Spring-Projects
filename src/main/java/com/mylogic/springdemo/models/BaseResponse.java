package com.mylogic.springdemo.models;

public abstract class BaseResponse {
    private String ErrorDescription;
    private int ErrorCode;

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.ErrorDescription = errorDescription;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }
}
