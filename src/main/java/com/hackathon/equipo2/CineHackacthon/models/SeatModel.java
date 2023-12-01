package com.hackathon.equipo2.CineHackacthon.models;

import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;

public class SeatModel {
    private long id;
    private long roomId;
    private int row;
    private int column;
    private SeatStatusEnum statusCode;

    public SeatModel() {
    }

    public SeatModel(long id, long roomId, int row, int column, SeatStatusEnum statusCode) {
        this.id = id;
        this.roomId = roomId;
        this.row = row;
        this.column = column;
        this.statusCode = statusCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public SeatStatusEnum getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(SeatStatusEnum statusCode) {
        this.statusCode = statusCode;
    }
}
