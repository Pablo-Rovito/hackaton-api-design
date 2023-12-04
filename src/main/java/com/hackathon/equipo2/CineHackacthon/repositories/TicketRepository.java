package com.hackathon.equipo2.CineHackacthon.repositories;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TicketRepository {

    public List<TicketModel> getAllBuyTickets() {
        System.out.println("getAllBuyTickets en TicketRepository");

        return CineHackacthonApplication.tickets;
    }//getAllBuyTickets

    public Optional<TicketModel> findTicketById(long ticketId) {
        System.out.println("findTicketById en TicketRepository");

        return CineHackacthonApplication.getBuyTicket().stream()
                .filter(ticketModel -> ticketId == ticketModel.getTicketId())
                .findFirst();
    }//findTicketById

    public TicketModel createTicket(TicketModel ticket) {
        System.out.println("createTicket en TicketRepository");

        CineHackacthonApplication.getBuyTicket().add(ticket);

        return ticket;
    }//createTicket

}//class