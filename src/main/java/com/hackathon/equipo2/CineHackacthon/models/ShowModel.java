package com.hackathon.equipo2.CineHackacthon.models;

public class ShowModel {
    private long showId;
    private RoomModel roomModel;
    private long movieId;
    private long scheduleId;

    public ShowModel() {
    }

    public ShowModel(long showId, RoomModel roomModel, long movieId, long scheduleId) {
        this.showId = showId;
        this.roomModel = roomModel;
        this.movieId = movieId;
        this.scheduleId = scheduleId;
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

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }
}
