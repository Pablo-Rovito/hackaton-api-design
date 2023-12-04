package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.repositories.TicketRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import com.hackathon.equipo2.CineHackacthon.validators.TicketSeatIsAvailableValidator;
import com.hackathon.equipo2.CineHackacthon.validators.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    ShowService showService;

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketValidator ticketValidator;
    @Autowired
    TicketSeatIsAvailableValidator ticketSeatIsAvailableValidator;
    @Autowired
    SeatService seatService;

    public List<TicketModel> getAllBuyTickets() {
        System.out.println("getAllBuyTickets en TicketService");

        return ticketRepository.getAllBuyTickets();
    }//getAllBuyTickets

    public TicketServiceResponse<TicketModel> findTicketById(long ticketId) {
        System.out.println("findTicketById en TicketService");

        return ticketValidator.ticketExist(ticketRepository.findTicketById(ticketId));
    }//findTicketById

    public TicketServiceResponse<TicketModel> createTicket(TicketModel ticket) {
        System.out.println("createTicket en TicketService");
        if(ticketSeatIsAvailableValidator.apply(ticket).isValid()){
            return new TicketServiceResponse<TicketModel>(ticketSeatIsAvailableValidator.apply(ticket).getTicketEnum(), ticket);
        }

        ShowServiceResponse<ShowModel> showResponse = showService.findById(ticket.getShowId());
        ticket.setShow(showResponse.getPayload());

        seatService.changeStatus(ticket.getSeatId(), ticket.getShowId(), SeatStatusEnum.UNAVAILABLE);
        ticketRepository.createTicket(ticket);

        return new TicketServiceResponse<TicketModel>(
                TicketEnum.CREATED,
                ticket);
    }//createTicket

}//class