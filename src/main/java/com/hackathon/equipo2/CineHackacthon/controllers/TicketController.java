package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.services.TicketService;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
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

    @GetMapping("/tickets/{id}")
    public TicketServiceResponse findTicketById(@PathVariable long ticketId) {
        System.out.println("findTicketById en TicketController");
        System.out.println("El id del ticket es: " + ticketId);

        return ticketService.findTicketById(ticketId);
    }//findTicketById

    @PostMapping("/ticket")
    public TicketServiceResponse createTicket(@RequestBody TicketModel ticket) {
        System.out.println("createTicket en TicketController");
        System.out.println("El id del show asociado al ticket es: " + ticket.getMovieId());
        System.out.println("La sala asociada al ticket es: " + ticket.getRoomModel());
        System.out.println("El id de la pelicula asociada al ticket es: " + ticket.getMovieId());
        System.out.println("El id del horario asociado al ticket es: " + ticket.getScheduleId());
        System.out.println("El id del ticket es: " + ticket.getTicketId());
        System.out.println("El id del asiento es: " + ticket.getSeatId());
        System.out.println("El precio del ticket es: " + ticket.getPrice());

        return ticketService.createTicket(ticket);
    }//createTicket

}//class
