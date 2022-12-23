package com.tm.exception;

import com.tm.result.ResultCodeEnum;

public class BusinessException extends RuntimeException{

    private Integer errorCode;

    private String errorMessage;

    public BusinessException() {
    }

    public BusinessException(ResultCodeEnum responseCode){
        this.errorCode = responseCode.getCode();
        this.errorMessage = responseCode.getMsg();
    }

    public BusinessException(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}