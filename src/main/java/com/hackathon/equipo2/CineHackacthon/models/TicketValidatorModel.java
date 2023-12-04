package com.hackathon.equipo2.CineHackacthon.models;

import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import com.hackathon.equipo2.CineHackacthon.utils.ValidatorEnum;

public class TicketValidatorModel extends ValidatorModel {
    private TicketEnum ticketEnum;

    public TicketValidatorModel() {
    }

    public TicketValidatorModel(boolean valid, ValidatorEnum validatorEnum, TicketEnum ticketEnum) {
        super(valid, validatorEnum);
        this.ticketEnum = ticketEnum;
    }

    public TicketEnum getTicketEnum() {
        return ticketEnum;
    }

    public void setTicketEnum(TicketEnum ticketEnum) {
        this.ticketEnum = ticketEnum;
    }
}
