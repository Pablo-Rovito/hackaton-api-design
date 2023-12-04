package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.ValidatorModel;
import com.hackathon.equipo2.CineHackacthon.repositories.RoomRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.RoomServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.RoomEnum;
import com.hackathon.equipo2.CineHackacthon.validators.roomValidators.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomValidator roomValidator;

    public List<RoomModel> findAll() {
        return roomRepository.findAll();
    }

    public RoomServiceResponse<RoomModel> findById(long roomId) {

        Optional<RoomModel> room = roomRepository.findById(roomId);

        ValidatorModel validation = roomValidator.exists(room);

        if(!validation.isValid()) {
            return new RoomServiceResponse<>(
                RoomEnum.NOT_FOUND.getHttpStatus(),
                RoomEnum.NOT_FOUND.getCode(),
                RoomEnum.NOT_FOUND.getMessage(),
                new RoomModel()
            );
        }

        return new RoomServiceResponse<>(
                RoomEnum.OK.getHttpStatus(),
                RoomEnum.OK.getCode(),
                RoomEnum.OK.getMessage(),
                room.get()
        );
    }

    public RoomServiceResponse<RoomModel> update(RoomModel updatedRoom) {

        Optional<RoomModel> room = roomRepository.findById(updatedRoom.getId());

        ValidatorModel validation = roomValidator.exists(room);

        if (!validation.isValid()) {
            return new RoomServiceResponse<>(
                    RoomEnum.NOT_FOUND.getHttpStatus(),
                    RoomEnum.NOT_FOUND.getCode(),
                    RoomEnum.NOT_FOUND.getMessage(),
                    new RoomModel()
            );
        }

        return new RoomServiceResponse<>(
                RoomEnum.OK.getHttpStatus(),
                RoomEnum.OK.getCode(),
                RoomEnum.OK.getMessage(),
                this.roomRepository.update(updatedRoom)
        );
    }

    public RoomServiceResponse<RoomModel> create(RoomModel room) {

        ValidatorModel response = roomValidator
                .alreadyInList(roomRepository.findById(room.getId()));

        if (!response.isValid()) {
            return new RoomServiceResponse<>(
                    RoomEnum.ROOM_ALREADY_CREATED.getHttpStatus(),
                    RoomEnum.ROOM_ALREADY_CREATED.getCode(),
                    RoomEnum.ROOM_ALREADY_CREATED.getMessage(),
                    new RoomModel()
            );
        }

        return new RoomServiceResponse<>(
                RoomEnum.CREATED.getHttpStatus(),
                RoomEnum.CREATED.getCode(),
                RoomEnum.CREATED.getMessage(),
                this.roomRepository.create(room)
        );
    }

    public RoomServiceResponse<RoomModel> delete(RoomModel roomToDelete) {
        Optional<RoomModel> room = roomRepository.findById(roomToDelete.getId());

        ValidatorModel validation = roomValidator.exists(room);


        if (!validation.isValid()) {
            return new RoomServiceResponse<>(
                    RoomEnum.NOT_FOUND.getHttpStatus(),
                    RoomEnum.NOT_FOUND.getCode(),
                    RoomEnum.NOT_FOUND.getMessage(),
                    new RoomModel()
            );
        }

        return new RoomServiceResponse<>(
                RoomEnum.OK.getHttpStatus(),
                RoomEnum.OK.getCode(),
                RoomEnum.OK.getMessage(),
                this.roomRepository.delete(roomToDelete)
        );
    }
}
