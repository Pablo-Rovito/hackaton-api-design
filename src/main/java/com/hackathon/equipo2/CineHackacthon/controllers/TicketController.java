package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.services.TicketService;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController extends Controller{

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
        System.out.println("El id del show asociado al ticket es: " + ticket.getShowId());
        System.out.println("La sala asociada al ticket es: " + ticket.getRoomModel());
        System.out.println("La pelicula asociada al ticket es: " + ticket.getMovie());
        System.out.println("El horario asociado al ticket es: " + ticket.getSchedule());
        System.out.println("El id del ticket es: " + ticket.getTicketId());
        System.out.println("El id del asiento es: " + ticket.getSeatId());
        System.out.println("El precio del ticket es: " + ticket.getPrice());

        return ticketService.createTicket(ticket);
    }//createTicket

}//class
