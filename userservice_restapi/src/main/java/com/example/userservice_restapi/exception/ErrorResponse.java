package com.example.userservice_restapi.exception;

public class ErrorResponse {

    private String errorMessage;
    private Integer statusCode;
    private Long errorReportingTime;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMessage, Integer statusCode, Long errorReportingTime) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.errorReportingTime = errorReportingTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Long getErrorReportingTime() {
        return errorReportingTime;
    }

    public void setErrorReportingTime(Long errorReportingTime) {
        this.errorReportingTime = errorReportingTime;
    }
}