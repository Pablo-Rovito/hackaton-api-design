package com.hackathon.equipo2.CineHackacthon.controllers;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.services.MovieService;
import com.hackathon.equipo2.CineHackacthon.services.responses.MovieServiceResponse;
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
        List<MovieModel> result = this.movieService.findAll().getMovies();

        return result;
    }

    @GetMapping("/movies/{id}")
    public MovieServiceResponse getMovieById(
            @PathVariable Long id
    ) {
        MovieServiceResponse result = this.movieService.findById(id);

        return result;
    }

    @PostMapping("/movies")
    public MovieServiceResponse addMovie(
            @RequestBody MovieModel movie
    ) {
        MovieServiceResponse result = this.movieService.add(movie);
        return result;
    }

    @DeleteMapping("/movies/{id}")
    public MovieServiceResponse deleteMovieById(
            @PathVariable Long id
    ) {
        MovieServiceResponse result = this.movieService.remove(id);
        return result;
    }

    @PutMapping("/movies")
    public MovieServiceResponse updateMovie(
            @RequestBody MovieModel movieModel
    ) {
        MovieServiceResponse result = this.movieService.update(movieModel);
        return result;
    }
}
