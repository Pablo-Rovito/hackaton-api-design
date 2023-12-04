package com.hackathon.equipo2.CineHackacthon.utils;

import org.springframework.http.HttpStatus;

public enum ShowServiceEnum {

    SHOW_CALL_OK ("SHW001", "The call was successfull", HttpStatus.OK),

    SHOW_CALL_ERROR ("SHW002", "The call was NOT successfull", HttpStatus.NOT_FOUND)

    ;

    private String code;
    private String message;
    private HttpStatus httpStatus;

    ShowServiceEnum(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
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

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
