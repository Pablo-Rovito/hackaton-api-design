package com.hackathon.equipo2.CineHackacthon.validators;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketValidator {

    public TicketServiceResponse<TicketModel> ticketExist(Optional<TicketModel> ticketFind) {

        if (ticketFind.isPresent()) {
            return new TicketServiceResponse<TicketModel>(
                    TicketEnum.OK,
                    new TicketModel(
                            new ShowModel(ticketFind.get().getShowId(),
                                        ticketFind.get().getRoomModel(),
                                        ticketFind.get().getMovie(),
                                        ticketFind.get().getSchedule(),
                                        ticketFind.get().getPrice()),
                            ticketFind.get().getTicketId(),
                            ticketFind.get().getSeatId()));
        }//if

        return new TicketServiceResponse<TicketModel>(
                TicketEnum.NOT_FOUND,
                new TicketModel());
    }//ticketExist

    public TicketServiceResponse<TicketModel> createTicket(TicketModel ticketBuy){

        return new TicketServiceResponse<TicketModel>(
                TicketEnum.CREATED,
                new TicketModel(
                        new ShowModel(ticketBuy.getShowId(),
                                ticketBuy.getRoomModel(),
                                ticketBuy.getMovie(),
                                ticketBuy.getSchedule(),
                                ticketBuy.getPrice()
                        ),
                        ticketBuy.getTicketId(),
                        ticketBuy.getSeatId()));
    }//createTicket

}//class