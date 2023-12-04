package com.hackathon.equipo2.CineHackacthon.validators;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.services.RoomService;
import com.hackathon.equipo2.CineHackacthon.services.responses.RoomServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.RoomEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoomValidator {

    public RoomServiceResponse<RoomModel> exists(Optional<RoomModel> model) {
        if(model.isEmpty()) {
            return new RoomServiceResponse(
                    RoomEnum.NOT_FOUND.getHttpStatus(),
                    RoomEnum.NOT_FOUND.getCode(),
                    RoomEnum.NOT_FOUND.getMessage(),
                    new RoomModel()
            );
        }

        return new RoomServiceResponse(
                RoomEnum.OK.getHttpStatus(),
                RoomEnum.OK.getCode(),
                RoomEnum.OK.getMessage(),
                new RoomModel(
                        model.get().getId(),
                        model.get().getSeats()
                )
        );
    }

    public RoomServiceResponse<RoomModel> alreadyInList(Optional<RoomModel> model) {
        if(!model.isEmpty()) {
            return new RoomServiceResponse(
                    RoomEnum.ROOM_ALREADY_CREATED.getHttpStatus(),
                    RoomEnum.ROOM_ALREADY_CREATED.getCode(),
                    RoomEnum.ROOM_ALREADY_CREATED.getMessage(),
                    model.get()
            );
        }

        return new RoomServiceResponse(
                RoomEnum.CREATED.getHttpStatus(),
                RoomEnum.CREATED.getCode(),
                RoomEnum.CREATED.getMessage(),
                new RoomModel()
        );
    }
}
