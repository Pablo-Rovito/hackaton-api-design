package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.services.SeatService;
import com.hackathon.equipo2.CineHackacthon.services.SeatServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apitheater/v1")
public class SeatController {
    @Autowired
    SeatService seatService;
    @GetMapping("/seats/{showId}")
    public ResponseEntity<SeatServiceResponse> getSeats(
            @PathVariable long showId,
            @RequestParam(value = "status", required = false) SeatStatusEnum status
            ){
        SeatServiceResponse serviceResponse = seatService.getSeats(showId, status);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getResponseHttpStatusCode());
    }
}
