package com.hackathon.equipo2.CineHackacthon.validators;

import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.repositories.ShowRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.ServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TicketSeatIsAvailableValidator {
    @Autowired
    ShowRepository showRepository;

    public ServiceResponse apply(TicketModel ticketModel) {
        ShowModel showModel = showRepository.findById(ticketModel.getShowId()).get();
        List<SeatModel> seatModels = showModel.getRoomModel().getSeats();
        SeatModel seatModel = seatModels.stream()
                .filter(seatModelInList -> seatModelInList.getId() == ticketModel.getSeatId())
                .findAny()
                .get();
        if(seatModel.getStatusCode() != SeatStatusEnum.AVAILABLE) {

        }
    }
}
