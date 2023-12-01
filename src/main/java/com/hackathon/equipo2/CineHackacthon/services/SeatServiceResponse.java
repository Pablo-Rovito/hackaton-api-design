package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public class SeatServiceResponse {
    private String msg;
    private List<SeatModel> seatModels;
    private HttpStatus responseHttpStatusCode;

    public SeatServiceResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SeatModel> getSeatModels() {
        return seatModels;
    }

    public void setSeatModels(List<SeatModel> seatModels) {
        this.seatModels = seatModels;
    }

    public HttpStatus getResponseHttpStatusCode() {
        return responseHttpStatusCode;
    }

    public void setResponseHttpStatusCode(HttpStatus responseHttpStatusCode) {
        this.responseHttpStatusCode = responseHttpStatusCode;
    }
}
