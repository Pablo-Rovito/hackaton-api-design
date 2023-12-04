package com.hackathon.equipo2.CineHackacthon.models;

public class TicketModel extends ShowModel {
    private long ticketId;
    private long seatId;
    private double price;

    public TicketModel(ShowModel show, long ticketId, long seatId, double price) {
        super(show.getShowId(), show.getRoomModel(), show.getMovie(), show.getSchedule());
        this.ticketId = ticketId;
        this.seatId = seatId;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
