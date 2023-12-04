package com.hackathon.equipo2.CineHackacthon.validators.roomValidators;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.ValidatorModel;
import com.hackathon.equipo2.CineHackacthon.utils.ValidatorEnum;
import com.hackathon.equipo2.CineHackacthon.validators.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoomValidator extends AbstractValidator<ValidatorModel, RoomModel> {

    public ValidatorModel exists(Optional<RoomModel> model) {
        if(model.isEmpty()) {
            return new ValidatorModel(
                    false,
                    ValidatorEnum.NOT_VALID
            );
        }

        return new ValidatorModel(
                true,
                ValidatorEnum.VALID
        );
    }

    public ValidatorModel alreadyInList(Optional<RoomModel> model) {
        if(model.isPresent()) {
            return new ValidatorModel(
                    false,
                    ValidatorEnum.NOT_VALID
            );
        }

        return new ValidatorModel(
                true,
                ValidatorEnum.VALID
        );
    }
}
