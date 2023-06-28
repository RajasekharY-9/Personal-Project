package com.infymemobileuser.utility;

import java.time.LocalDateTime;

public class ErrorInformation {
    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime errorTimeStamp;

 

    // Constructors, getters, and setters

 

    // Default constructor
    public ErrorInformation() {
    }

 

    // Parameterized constructor
    public ErrorInformation(String errorMessage, Integer errorCode, LocalDateTime errorTimeStamp) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorTimeStamp = errorTimeStamp;
    }

 

    // Getters and setters

 

    public String getErrorMessage() {
        return errorMessage;
    }

 

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

 

    public Integer getErrorCode() {
        return errorCode;
    }

 

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

 

    public LocalDateTime getErrorTimeStamp() {
        return errorTimeStamp;
    }

 

    public void setErrorTimeStamp(LocalDateTime errorTimeStamp) {
        this.errorTimeStamp = errorTimeStamp;
    }
}