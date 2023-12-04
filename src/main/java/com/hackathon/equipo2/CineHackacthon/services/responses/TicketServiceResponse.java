package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import org.springframework.http.HttpStatus;

public class TicketServiceResponse extends ServiceResponse {

    public TicketServiceResponse() {
    }

    public TicketServiceResponse(HttpStatus httpStatus, String code, String message, TicketModel payload, boolean success) {
        super(httpStatus, code, message, payload, success);
    }


    public TicketServiceResponse(TicketEnum ticketEnum, TicketModel payload, boolean success) {
        super(ticketEnum.getHttpStatus(), ticketEnum.getCode(), ticketEnum.getMessage(), payload, success);
    }

}//class