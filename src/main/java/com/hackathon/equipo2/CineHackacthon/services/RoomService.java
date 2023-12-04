package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.repositories.RoomRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.RoomServiceResponse;
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

    public RoomServiceResponse findById(long roomId) {

        return roomValidator
                .exists(roomRepository.findById(roomId));
    }

    public RoomServiceResponse update(RoomModel updatedRoom) {

        RoomServiceResponse response = roomValidator
                .exists(roomRepository.findById(updatedRoom.getId()));


        if(!response.isSuccess()) {
            return response;
        }

        RoomModel payload = (RoomModel) response.getPayload();
        payload.setSeats(updatedRoom.getSeats());

        return response;
    }

    public RoomServiceResponse create(RoomModel room) {

        RoomServiceResponse response = roomValidator
                .alreadyInList(roomRepository.findById(room.getId()));


        if(!response.isSuccess()) {
            return response;
        }

        response.setPayload(this.roomRepository.create(room));

        return response;
    }

    public RoomServiceResponse delete(RoomModel room) {
        RoomServiceResponse response = roomValidator
                .exists(roomRepository.findById(room.getId()));


        if(!response.isSuccess()) {
            return response;
        }

        response.setPayload(this.roomRepository.delete(room));

        return response;
    }
}
