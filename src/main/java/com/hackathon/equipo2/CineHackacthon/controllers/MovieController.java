package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController extends com.hackathon.equipo2.CineHackacthon.controllers.Controller {

    @Autowired
    MovieService movieService;


    @GetMapping("/movies")
    public List<MovieModel> findAll() {
        List<MovieModel> result = this.movieService.findAll().stream().toList();

        return result;
    }

    @GetMapping("/movies/{id}")
    public MovieModel getMovieById(
            @PathVariable Long id
    ) {
        MovieModel result = this.movieService.findById(id);

        return result;
    }

    @PostMapping("/movies")
    public MovieModel addMovie(
            @RequestBody MovieModel movie
    ) {
        this.movieService.add(movie);
        return movie;
    }

    @DeleteMapping("/movies/{id}")
    public Boolean deleteMovieById(
            @PathVariable Long id
    ) {

        return this.movieService.remove(id);
    }

    @PutMapping("/movies")
    public Boolean updateMovie(
            @RequestBody MovieModel movieModel
    ) {
        return this.movieService.update(movieModel);
    }
}
