package com.hackathon.equipo2.CineHackacthon.utils;

import org.springframework.http.HttpStatus;

public enum RoomEnum {
    OK ("RM001", "data found", HttpStatus.OK),
    NOT_FOUND ("RM002", "no rooms found", HttpStatus.NOT_FOUND),
    CREATED ("RM003", "room created", HttpStatus.CREATED),
    ROOM_ALREADY_CREATED ("RM004", "room already listed", HttpStatus.METHOD_NOT_ALLOWED);

    private String code;
    private String message;
    private HttpStatus httpStatus;

    RoomEnum(String code, String message, HttpStatus httpStatus) {
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
