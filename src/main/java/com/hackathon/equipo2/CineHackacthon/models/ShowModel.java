package com.hackathon.equipo2.CineHackacthon.models;

public class ShowModel {
    private long showId;
    private RoomModel roomModel;
    private MovieModel movie;
    private ScheduleModel schedule;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ShowModel() {
    }

    public ShowModel(long showId, RoomModel roomModel, MovieModel movie, ScheduleModel schedule, double price) {
//        this.showId = showId;
        this.showId = showId;
        this.roomModel = roomModel;
        this.movie = movie;
        this.schedule = schedule;
        this.price = price;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void setRoomModel(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }

    public ScheduleModel getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleModel schedule) {
        this.schedule = schedule;
    }
}
