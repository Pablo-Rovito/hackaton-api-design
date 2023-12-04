package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.repositories.RoomRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.RoomServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.RoomEnum;
import com.hackathon.equipo2.CineHackacthon.validators.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return roomValidator
                .exists(roomRepository.findById(roomId));
    }

    public RoomServiceResponse<RoomModel> update(RoomModel updatedRoom) {

        RoomServiceResponse<RoomModel> response = roomValidator
                .exists(roomRepository.findById(updatedRoom.getId()));


        if (!response.getCode().equals(RoomEnum.OK.getCode())) {
            return response;
        }

        RoomModel payload = (RoomModel) response.getPayload();
        payload.setSeats(updatedRoom.getSeats());

        return response;
    }

    public RoomServiceResponse<RoomModel> create(RoomModel room) {

        RoomServiceResponse<RoomModel> response = roomValidator
                .alreadyInList(roomRepository.findById(room.getId()));

        if (!response.getCode().equals(RoomEnum.CREATED.getCode())) {
            return response;
        }

        response.setPayload(this.roomRepository.create(room));

        return response;
    }

    public RoomServiceResponse<RoomModel> delete(RoomModel room) {
        RoomServiceResponse<RoomModel> response = roomValidator
                .exists(roomRepository.findById(room.getId()));


        if (!response.getCode().equals(RoomEnum.OK.getCode())) {
            return response;
        }

        response.setPayload(this.roomRepository.delete(room));

        return response;
    }
}
