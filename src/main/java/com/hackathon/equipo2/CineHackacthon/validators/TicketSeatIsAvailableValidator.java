package com.hackathon.equipo2.CineHackacthon.validators;

import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketValidatorModel;
import com.hackathon.equipo2.CineHackacthon.repositories.ShowRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.ServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import com.hackathon.equipo2.CineHackacthon.utils.ValidatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TicketSeatIsAvailableValidator extends AbstractValidator<TicketModel, TicketValidatorModel>{
    @Autowired
    ShowRepository showRepository;

    public TicketValidatorModel apply(TicketModel ticketModel) {
        ShowModel showModel = showRepository.findById(ticketModel.getShowId()).get();

        Optional<SeatModel> seatModel = showModel.getRoomModel().getSeats()
                .stream()
                .filter(seatModelInList -> seatModelInList.getId() == ticketModel.getSeatId())
                .findAny();

        if(seatModel.isEmpty()) {
            return new TicketValidatorModel(
                    false,
                    ValidatorEnum.NOT_VALID,
                    TicketEnum.SEAT_NOT_FOUND);
        }

        if(seatModel.get().getStatusCode() == SeatStatusEnum.AVAILABLE || seatModel.get().getStatusCode() == SeatStatusEnum.RESERVED) {
            return new TicketValidatorModel(
                    false,
                    ValidatorEnum.NOT_VALID,
                    TicketEnum.SEAT_TAKEN);
        }

        return new TicketValidatorModel(
                true,
                ValidatorEnum.VALID,
                TicketEnum.CREATED);
    }
}
