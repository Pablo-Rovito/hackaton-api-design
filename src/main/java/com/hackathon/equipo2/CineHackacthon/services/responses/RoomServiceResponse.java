package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import org.springframework.http.HttpStatus;

public class RoomServiceResponse extends ServiceResponse {
    public RoomServiceResponse() {
    }

    public RoomServiceResponse(HttpStatus httpStatus, String code, String message, RoomModel payload, boolean success) {
        super(httpStatus, code, message, payload, success);
    }
}
