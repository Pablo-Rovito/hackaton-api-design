package com.hackathon.equipo2.CineHackacthon.models;

public class TicketModel extends ShowModel {
    private long ticketId;
    private long seatId;

    public TicketModel(){

    }

    public TicketModel(ShowModel show, long ticketId, long seatId) {
        super(show.getShowId(), show.getRoomModel(), show.getMovie(), show.getSchedule(), show.getPrice());
        this.ticketId = ticketId;
        this.seatId = seatId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public void setShow(ShowModel show) {
        this.setShowId(show.getShowId());
        this.setPrice(show.getPrice());
        this.setMovie(show.getMovie());
        this.setRoomModel(show.getRoomModel());
        this.setSchedule(show.getSchedule());
    }

}//class
