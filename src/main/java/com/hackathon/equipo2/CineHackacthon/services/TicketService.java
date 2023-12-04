package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketValidatorModel;
import com.hackathon.equipo2.CineHackacthon.repositories.TicketRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
import com.hackathon.equipo2.CineHackacthon.validators.AbstractValidator;
import com.hackathon.equipo2.CineHackacthon.validators.TicketSeatIsAvailableValidator;
import com.hackathon.equipo2.CineHackacthon.validators.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketValidator ticketValidator;
    @Autowired
    TicketSeatIsAvailableValidator ticketSeatIsAvailableValidator;

    public List<TicketModel> getAllBuyTickets() {
        System.out.println("getAllBuyTickets en TicketService");

        return ticketRepository.getAllBuyTickets();
    }//getAllBuyTickets

    public TicketServiceResponse findTicketById(long ticketId) {
        System.out.println("findTicketById en TicketService");

        return ticketValidator.ticketExist(ticketRepository.findTicketById(ticketId));
    }//findTicketById

    public TicketServiceResponse createTicket(TicketModel ticket) {
        System.out.println("createTicket en TicketService");
        if(ticketSeatIsAvailableValidator.apply(ticket).isValid()){
            return new TicketServiceResponse(ticketSeatIsAvailableValidator.apply(ticket).getTicketEnum(), ticket);
        }
        return ticketValidator.createTicket(ticketRepository.createTicket(ticket));
    }//createTicket

}//class