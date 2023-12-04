package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.repositories.TicketRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import com.hackathon.equipo2.CineHackacthon.validators.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketValidator ticketValidator;

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

        return ticketValidator.createTicket(ticketRepository.createTicket(ticket));
    }//createTicket

}//class