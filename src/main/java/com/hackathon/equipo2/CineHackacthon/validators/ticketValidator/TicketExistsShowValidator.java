package com.hackathon.equipo2.CineHackacthon.validators.ticketValidator;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketValidatorModel;
import com.hackathon.equipo2.CineHackacthon.services.ShowService;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.ShowServiceEnum;
import com.hackathon.equipo2.CineHackacthon.utils.TicketEnum;
import com.hackathon.equipo2.CineHackacthon.utils.ValidatorEnum;
import com.hackathon.equipo2.CineHackacthon.validators.AbstractValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketExistsShowValidator  extends AbstractValidator<TicketModel, TicketValidatorModel>  {
    @Autowired
    ShowService showService;

    @Override
    public TicketValidatorModel apply(TicketModel key) {

        return this.existsShow(key);
    }

    private TicketValidatorModel existsShow(TicketModel ticketModel) {

        boolean valid = true;
        TicketValidatorModel ticketValidator = new TicketValidatorModel(valid, ValidatorEnum.VALID, TicketEnum.OK);
        ShowServiceResponse<ShowModel> showResponse = this.showService.findById(ticketModel.getShowId());
        if (!showResponse.getCode().equals(ShowServiceEnum.SHOW_CALL_OK.getCode())) {
            valid = false;
            ticketValidator  = new TicketValidatorModel(valid, ValidatorEnum.NOT_VALID, TicketEnum.NOT_FOUND);
        }

        return ticketValidator;
    }


}
