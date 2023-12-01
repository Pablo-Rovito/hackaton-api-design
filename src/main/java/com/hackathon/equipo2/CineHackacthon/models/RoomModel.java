package com.hackathon.equipo2.CineHackacthon.models;

import java.util.List;

public class RoomModel {
    private long id;
    private List<SeatModel> seats;

    public RoomModel() {
    }

    public RoomModel(long id, List<SeatModel> seats) {
        this.id = id;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SeatModel> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatModel> seats) {
        this.seats = seats;
    }
}
