package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import org.springframework.http.HttpStatus;

public class TicketServiceResponse<T> extends ServiceResponse<T> {

    public TicketServiceResponse() {
    }

    public TicketServiceResponse(TicketEnum ticketEnum, T payload) {
        super(ticketEnum.getHttpStatus(), ticketEnum.getCode(), ticketEnum.getMessage(), payload);
    }


}//class