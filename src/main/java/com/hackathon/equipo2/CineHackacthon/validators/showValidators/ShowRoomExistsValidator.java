package com.hackathon.equipo2.CineHackacthon.validators.showValidators;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowValidatorModel;
import com.hackathon.equipo2.CineHackacthon.services.RoomService;
import com.hackathon.equipo2.CineHackacthon.services.responses.RoomServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.RoomEnum;
import com.hackathon.equipo2.CineHackacthon.utils.ShowValidatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShowRoomExistsValidator extends AbstractShowValidator {
    @Autowired
    RoomService roomService;

    @Override
    public ShowValidatorModel apply(ShowModel key) {
        return this.existsRoom(key);
    }

    private ShowValidatorModel existsRoom(ShowModel showModel) {

        boolean valid = true;
        ShowValidatorModel validation = new ShowValidatorModel(valid, ShowValidatorEnum.SHOW_VALID);
        RoomServiceResponse<RoomModel> response = this.roomService.findById(showModel.getRoomModel().getId());

        if (!response.getCode().equals(RoomEnum.OK.getCode())) {
            valid = false;
            validation = new ShowValidatorModel(valid, ShowValidatorEnum.SHOW_ROOM_NOT_EXISTS);
        }


        return  validation;

    }



}
