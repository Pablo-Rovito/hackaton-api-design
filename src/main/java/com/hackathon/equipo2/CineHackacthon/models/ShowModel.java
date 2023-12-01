package com.hackathon.equipo2.CineHackacthon.models;

public class ShowModel {
    private long showId;
    private long roomId;
    private long movieId;
    private long scheduleId;

    public ShowModel() {
    }

    public ShowModel(long showId, long roomId, long movieId, long scheduleId) {
        this.showId = showId;
        this.roomId = roomId;
        this.movieId = movieId;
        this.scheduleId = scheduleId;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
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
