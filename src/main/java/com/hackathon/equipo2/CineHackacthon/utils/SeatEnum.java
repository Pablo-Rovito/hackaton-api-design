package com.hackathon.equipo2.CineHackacthon.utils;

import org.springframework.http.HttpStatus;

public enum SeatEnum {
    OK ("ST001", "data found", HttpStatus.OK),
    NOT_FOUND ("ST002", "no seats found", HttpStatus.NOT_FOUND),
    CREATED ("ST003", "seat created", HttpStatus.CREATED),
    SEAT_ALREADY_CREATED ("ST004", "seat already listed", HttpStatus.METHOD_NOT_ALLOWED);

    private String code;
    private String message;
    private HttpStatus httpStatus;

    SeatEnum(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
