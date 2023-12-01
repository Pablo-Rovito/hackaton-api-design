package com.hackathon.equipo2.CineHackacthon.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController extends Controller {


    @RequestMapping("/shows")
    public void getShows() {
        System.out.println("getShows");
    }



}
