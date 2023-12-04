package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public class SeatServiceResponse extends ServiceResponse{
    public SeatServiceResponse() {
    }

    public SeatServiceResponse(HttpStatus httpStatus, String code, String message, SeatModel payload, boolean success) {
        super(httpStatus, code, message, payload, success);
    }
}
