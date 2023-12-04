package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.utils.MovieEnum;
import org.springframework.http.HttpStatus;

import java.util.List;

public class MovieServiceResponse<T> extends ServiceResponse<T> {
    List<MovieModel> movies = null;

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }


    public List<MovieModel> getMovies() {
        return movies;
    }

    public MovieServiceResponse() {

    }

    public MovieServiceResponse(HttpStatus httpStatus, String code, String message, T payload) {
        super(httpStatus, code, message, payload);
    }
    public MovieServiceResponse(HttpStatus httpStatus, String code, String message, T payload, List<MovieModel> movies ) {
        super(httpStatus, code, message, payload);
        this.movies = movies;
    }
}
