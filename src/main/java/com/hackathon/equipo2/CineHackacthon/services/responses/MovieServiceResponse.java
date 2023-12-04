package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.utils.MovieEnum;
import org.springframework.http.HttpStatus;

import java.util.List;

public class MovieServiceResponse extends ServiceResponse {
    List<MovieModel> movies = null;

    public List<MovieModel> getMovies() {
        return movies;
    }

    public MovieServiceResponse() {

    }

    public MovieServiceResponse(HttpStatus httpStatus, String code, String message, MovieModel payload) {
        super(httpStatus, code, message, payload);
    }
    public MovieServiceResponse(HttpStatus httpStatus, String code, String message, MovieModel payload, List<MovieModel> movies ) {
        super(httpStatus, code, message, payload);
        this.movies = movies;
    }
}
