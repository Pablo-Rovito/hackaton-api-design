package com.hackathon.equipo2.CineHackacthon.utils;

import org.springframework.http.HttpStatus;

public enum TicketEnum {

    OK ("T001", "Ticket encontrado", HttpStatus.OK),
    NOT_FOUND ("T002", "Ticket no encontrado",HttpStatus.NOT_FOUND),
    CREATED ("T003", "Ticket comprado", HttpStatus.CREATED),
    SEAT_TAKEN ("T004", "This seat is taken", HttpStatus.BAD_REQUEST),
    SEAT_NOT_FOUND ("T005", "This seat doesn't exist", HttpStatus.NOT_FOUND),
    SHOW_NOT_FOUND ("T006", "This show doesn't exist", HttpStatus.NOT_FOUND);

    private String code;
    private String message;
    private HttpStatus httpStatus;

    TicketEnum(String code, String message, HttpStatus httpStatus) {
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

}//class