package com.hackathon.equipo2.CineHackacthon.utils;

import org.springframework.http.HttpStatus;

public enum MovieEnum {
    OK ("RM001", "movie data found", HttpStatus.OK),
    NOT_FOUND ("RM002", "no movie found", HttpStatus.NOT_FOUND),
    CREATED ("RM003", "Movie created", HttpStatus.CREATED),
    MOVIE_ALREADY_CREATED ("RM004", "movie already listed", HttpStatus.METHOD_NOT_ALLOWED);

    private String code;
    private String message;
    private HttpStatus httpStatus;

    MovieEnum(String code, String message, HttpStatus httpStatus) {
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
