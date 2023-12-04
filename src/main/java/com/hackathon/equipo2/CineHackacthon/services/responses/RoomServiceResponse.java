package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import org.springframework.http.HttpStatus;

public class RoomServiceResponse<T> extends ServiceResponse<T> {
    public RoomServiceResponse() {
    }

    public RoomServiceResponse(HttpStatus httpStatus, String code, String message, T payload) {
        super(httpStatus, code, message, payload);
    }
}
