package com.hackathon.equipo2.CineHackacthon.validators;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketValidator {

    public TicketServiceResponse ticketExist(Optional<TicketModel> ticketFind) {

        if (ticketFind.isPresent()) {
            return new TicketServiceResponse(
                    TicketEnum.OK,
                    new TicketModel(
                            new ShowModel(ticketFind.get().getShowId(),
                                        ticketFind.get().getRoomModel(),
                                        ticketFind.get().getMovieId(),
                                        ticketFind.get().getScheduleId()
                                    ),
                            ticketFind.get().getTicketId(),
                            ticketFind.get().getSeatId(),
                            ticketFind.get().getPrice()),
                    true);
        }//if

        return new TicketServiceResponse(
                TicketEnum.NOT_FOUND,
                new TicketModel(),
                false);
    }//ticketExist

    public TicketServiceResponse createTicket(TicketModel ticketBuy){

        return new TicketServiceResponse(
                TicketEnum.CREATED,
                new TicketModel(
                        new ShowModel(ticketBuy.getShowId(),
                                ticketBuy.getRoomModel(),
                                ticketBuy.getMovieId(),
                                ticketBuy.getScheduleId()
                        ),
                        ticketBuy.getTicketId(),
                        ticketBuy.getSeatId(),
                        ticketBuy.getPrice()),
                true
        );
    }//createTicket

}//class