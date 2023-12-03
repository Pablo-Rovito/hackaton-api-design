package com.hackathon.equipo2.CineHackacthon.services.responses;

import org.springframework.http.HttpStatus;

public abstract class ServiceResponse {
    private boolean success;
    private HttpStatus httpStatus;
    private String code;
    private String message;
    private Object payload;

    public ServiceResponse() {
    }

    public ServiceResponse(HttpStatus httpStatus, String code, String message, Object payload, boolean success) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.payload = payload;
        this.success = success;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
