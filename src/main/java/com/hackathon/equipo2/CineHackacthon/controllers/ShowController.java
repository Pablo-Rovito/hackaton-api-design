package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.services.ShowService;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowController extends Controller {
    @Autowired
    ShowService showService;

    @GetMapping("/shows")
    public ResponseEntity<ShowServiceResponse<List<ShowModel>>> getShows() {
        System.out.println("getShows");

        ShowServiceResponse<List<ShowModel>> response = this.showService.findAll();

        return new ResponseEntity<>(response, response.getHttpStatus());

    }

    @GetMapping("/shows/{id}")
    public ResponseEntity<ShowServiceResponse<ShowModel>> getShowById(@PathVariable Long id) {
        System.out.println("getShowById");

        ShowServiceResponse<ShowModel> response = this.showService.findById(id);

        return new ResponseEntity<>(response, response.getHttpStatus());

    }

    @PostMapping("/shows")
    public ResponseEntity<ShowServiceResponse<ShowModel>> addShow(@RequestBody ShowModel show) {
        System.out.println("addShow");

        ShowServiceResponse<ShowModel> response = this.showService.addShow(show);

        return new ResponseEntity<>(response, response.getHttpStatus());

    }

    @DeleteMapping("/shows/{id}")
    public ResponseEntity<ShowServiceResponse<ShowModel>> deleteShow(@PathVariable Long id) {
        System.out.println("deleteShow");

        ShowServiceResponse<ShowModel> response = this.showService.deleteShow(id);

        return new ResponseEntity<>(response, response.getHttpStatus());

    }



}
