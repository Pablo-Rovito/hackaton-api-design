package com.hackathon.equipo2.CineHackacthon.utils;

import com.hackathon.equipo2.CineHackacthon.models.ValidatorModel;

public enum ShowValidatorEnum {


    SHOW_ROOM_NOT_EXISTS            ("SVL001", "Can not add show bc room does not exists"),

    SHOW_MOVIE_NOT_EXISTS           ("SVL002", "Can not add show bc movie does not exists"),
    SHOW_MOVIE_SCHEDULE_OVERLAP     ("SVL003", "Can not add show bc movie does not exists"),

    SHOW_VALID                      ("SVL005", "Can not add show bc room does not exists"),

    SHOW_ADD_VALID                  ("SVL004", "Show added successfully")


    ;

    private String code;
    private String message;

    ShowValidatorEnum(String code, String message) {
        this.code = code;
        this.message = message;
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
}
