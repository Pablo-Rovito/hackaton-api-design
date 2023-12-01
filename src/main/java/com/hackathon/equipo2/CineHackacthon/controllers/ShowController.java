package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.services.ShowService;
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
    public ResponseEntity<List<ShowModel>> getShows() {
        System.out.println("getShows");

        List<ShowModel> result = this.showService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/shows/{id}")
    public ResponseEntity<ShowModel> getShowById(@PathVariable Long id) {
        System.out.println("getShowById");

        Optional<ShowModel> result = this.showService.findById(id);

        return new ResponseEntity<>(result.isPresent() ? result.get() : new ShowModel(), HttpStatus.OK);

    }

    @PostMapping("/shows")
    public ResponseEntity<ShowModel> addShow(@RequestBody ShowModel show) {
        System.out.println("addShow");

        ShowModel result = this.showService.addShow(show);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @DeleteMapping("/shows/{id}")
    public ResponseEntity<ShowModel> deleteShow(@PathVariable Long id) {
        System.out.println("deleteShow");

        ShowModel result = this.showService.deleteShow(id);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }



}
