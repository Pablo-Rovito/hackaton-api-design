package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public List<TicketModel> getAllBuyTickets() {
        System.out.println("getAllBuyTickets en TicketController");

        return ticketService.getAllBuyTickets();
    }//getAllBuyTickets

    @GetMapping("/tickets/ id}")
    public ResponseEntity<Object> findTicketById(@PathVariable long ticketId) {
        System.out.println("findTicketById en TicketController");
        System.out.println("El id del ticket es: " + ticketId);

        Optional<TicketModel> ticketById = ticketService.findTicketById(ticketId);

        return new ResponseEntity<>(ticketById.isPresent() ? ticketById.get() : "Ticket no encontrado",
                ticketById.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }//findTicketById

    @PostMapping("/ticket")
    public ResponseEntity<TicketModel> createTicket(@RequestBody TicketModel ticket) {
        System.out.println("createTicket en TicketController");
        System.out.println("El id del ticket es: " + ticket.getTicketId());
        System.out.println("El id del asiento es: " + ticket.getSeatId());
        System.out.println("El precio del ticket es: " + ticket.getPrice());

        return new ResponseEntity<>(this.ticketService.createTicket(ticket), HttpStatus.CREATED);

    }//createTicket

}//class
