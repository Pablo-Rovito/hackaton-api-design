package com.hackathon.equipo2.CineHackacthon.utils;

import com.hackathon.equipo2.CineHackacthon.models.ValidatorModel;
import org.springframework.http.HttpStatus;

public enum ShowValidatorEnum {


    SHOW_ROOM_NOT_EXISTS            ("SVL001", "Can not add show bc room does not exists", HttpStatus.NOT_FOUND),

    SHOW_MOVIE_NOT_EXISTS           ("SVL002", "Can not add show bc movie does not exists", HttpStatus.NOT_FOUND),
    SHOW_MOVIE_SCHEDULE_OVERLAP     ("SVL003", "Can not add show bc of schedule overlap", HttpStatus.BAD_REQUEST),

    SHOW_VALID                      ("SVL005", "Show validator was okay", HttpStatus.OK),

    SHOW_ADD_VALID                  ("SVL004", "Show added successfully", HttpStatus.OK),

    SHOW_NOT_EXISTS                ("SVL006", "Show added successfully", HttpStatus.OK)


    ;

    private String code;
    private String message;
    private HttpStatus httpStatus;


    ShowValidatorEnum(String code, String message, HttpStatus httpStatus) {
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
