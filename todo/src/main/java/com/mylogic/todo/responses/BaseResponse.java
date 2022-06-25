package com.mylogic.todo.responses;

public abstract class BaseResponse {
    private int ErorCode;
    private String ErrorDescription;

    public int getErorCode() {
        return ErorCode;
    }

    public void setErorCode(int erorCode) {
        ErorCode = erorCode;
    }

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        ErrorDescription = errorDescription;
    }
}
