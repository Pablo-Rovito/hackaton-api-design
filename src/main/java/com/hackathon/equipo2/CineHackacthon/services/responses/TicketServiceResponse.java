package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import org.springframework.http.HttpStatus;

public class TicketServiceResponse extends ServiceResponse<TicketModel> {

    public TicketServiceResponse() {
    }

    public TicketServiceResponse(HttpStatus httpStatus, String code, String message, TicketModel payload) {
        super(httpStatus, code, message, payload);
    }


    public TicketServiceResponse(TicketEnum ticketEnum, TicketModel payload) {
        super(ticketEnum.getHttpStatus(), ticketEnum.getCode(), ticketEnum.getMessage(), payload);
    }

}//class