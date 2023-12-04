package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public class SeatServiceResponse<T> extends ServiceResponse<T>{
    public SeatServiceResponse() {
    }

    public SeatServiceResponse(HttpStatus httpStatus, String code, String message, T payload) {
        super(httpStatus, code, message, payload);
    }
}
