package com.mamun.springrest.common;

public class Response {
    private String status;
    private String responseCode;
    private String responseMessage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Response(String status, String responseCode, String responseMessage) {
        this.status = status;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
}
