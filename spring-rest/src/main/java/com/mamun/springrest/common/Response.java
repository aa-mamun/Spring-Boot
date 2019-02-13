package com.mamun.springrest.common;

public class Response {
    private Status status;
    private String responseCode;
    private String responseMessage;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Response(Status status, String responseCode, String responseMessage) {
        this.status = status;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public Response() {
    }
}
