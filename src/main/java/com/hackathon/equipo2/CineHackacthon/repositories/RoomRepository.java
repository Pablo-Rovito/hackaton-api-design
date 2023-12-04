package com.hackathon.equipo2.CineHackacthon.repositories;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {
    public List<RoomModel> findAll() {
        return CineHackacthonApplication.rooms;
    }

    public Optional<RoomModel> findById(long roomId) {
        return CineHackacthonApplication.rooms
                .stream()
                .filter(room -> roomId == room.getId())
                .findFirst();
    }

    public RoomModel update(RoomModel updatedRoom) {
        RoomModel room = this.findById(updatedRoom.getId()).get();

        room.setSeats(updatedRoom.getSeats());
        return updatedRoom;
    }

    public RoomModel create(RoomModel room) {
        CineHackacthonApplication.rooms.add(room);
        return room;
    }

    public RoomModel delete(RoomModel room) {
        CineHackacthonApplication.rooms.remove(room);
        return room;
    }
}
