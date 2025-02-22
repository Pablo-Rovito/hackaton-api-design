package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import com.hackathon.equipo2.CineHackacthon.services.SeatService;
import com.hackathon.equipo2.CineHackacthon.services.responses.SeatServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController extends Controller{
    @Autowired
    SeatService seatService;
    @GetMapping("/seats/{showId}")
    public ResponseEntity<SeatServiceResponse<List<SeatModel>>> getSeats(
            @PathVariable long showId,
            @RequestParam(value = "status", required = false) SeatStatusEnum status
            ){
        SeatServiceResponse<List<SeatModel>> serviceResponse = seatService.getSeats(showId, status);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getHttpStatus());
    }
}
