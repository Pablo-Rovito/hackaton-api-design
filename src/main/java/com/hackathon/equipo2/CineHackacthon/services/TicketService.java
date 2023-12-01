package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.repositories.TicketRepository;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
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

    public List<TicketModel> getAllBuyTickets() {
        System.out.println("getAllBuyTickets en TicketService");
        return ticketRepository.getAllBuyTickets();
    }//getAllBuyTickets

    public Optional<TicketModel> findTicketById(long ticketId) {
        System.out.println("findTicketById en TicketService");

        return ticketRepository.findTicketById(ticketId);
    }//findTicketById

    public TicketModel createTicket(TicketModel ticket) {
        System.out.println("createTicket en TicketService");

        return ticketRepository.createTicket(ticket);
    }//createTicket


//    private boolean availableSeat(long seatId) {
//        Optional<SeatModel> seat =
//    }//availableSeat




}//class