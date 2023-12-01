package com.hackathon.equipo2.CineHackacthon.utils;

public enum ShowEnum {

    SHOW_CALL_OK ("SHW001", "The call was successfull"),

    SHOW_CALL_ERROR ("SHW002", "The call was NOT successfull")


    ;

    private String code;
    private String message;

    ShowEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
