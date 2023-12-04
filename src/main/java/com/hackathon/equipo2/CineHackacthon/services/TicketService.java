package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketValidatorModel;
import com.hackathon.equipo2.CineHackacthon.repositories.TicketRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import com.hackathon.equipo2.CineHackacthon.services.responses.TicketServiceResponse;
import com.hackathon.equipo2.CineHackacthon.validators.AbstractValidator;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import com.hackathon.equipo2.CineHackacthon.validators.TicketSeatIsAvailableValidator;
import com.hackathon.equipo2.CineHackacthon.validators.TicketValidator;
import com.hackathon.equipo2.CineHackacthon.validators.ticketValidator.TicketExistsShowValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    SeatService seatService;
    @Autowired
    TicketExistsShowValidator ticketExistsShowValidator;

    @Autowired
    TicketSeatIsAvailableValidator ticketSeatIsAvailableValidator;

    List<AbstractValidator<TicketModel, TicketValidatorModel>> validators;

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

        TicketServiceResponse<TicketModel> responseService = new TicketServiceResponse<TicketModel>();

        TicketModel ticketEmpty = new TicketModel();

        validators = new ArrayList<AbstractValidator<TicketModel, TicketValidatorModel>>();
        validators.add(ticketExistsShowValidator);
        validators.add(ticketSeatIsAvailableValidator);
        for (AbstractValidator<TicketModel, TicketValidatorModel> validator: validators) {
            TicketValidatorModel valid = validator.apply(ticket);
            if (!valid.isValid()) {
                responseService = new TicketServiceResponse<TicketModel>(valid.getTicketEnum(), ticketEmpty);
                return responseService;
            }
        }

        ShowServiceResponse<ShowModel> showResponse = showService.findById(ticket.getShowId());
        ticket.setShow(showResponse.getPayload());

        seatService.changeStatus(ticket.getSeatId(), ticket.getShowId(), SeatStatusEnum.UNAVAILABLE);

        responseService = ticketValidator.createTicket(ticketRepository.createTicket(ticket));
        return responseService;
    }//createTicket

}//class