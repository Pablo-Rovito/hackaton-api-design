package com.hackathon.equipo2.CineHackacthon.utils;

public enum ValidatorEnum {


    VALID               ("VAL001", "Valid"),
    NOT_VALID           ("VAL002", "Not Valid")


    ;

    private String code;
    private String message;

    ValidatorEnum(String code, String message) {
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
