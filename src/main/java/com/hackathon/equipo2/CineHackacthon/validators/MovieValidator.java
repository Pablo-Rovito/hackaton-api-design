package com.hackathon.equipo2.CineHackacthon.validators;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.services.responses.MovieServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.MovieEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MovieValidator {
    public MovieServiceResponse existMovieList(List<MovieModel> movies) {
        if(movies != null) {
            return new MovieServiceResponse(MovieEnum.OK.getHttpStatus(),MovieEnum.OK.getCode(),MovieEnum.OK.getMessage(), null, movies);

        } else {
            return new MovieServiceResponse(MovieEnum.NOT_FOUND.getHttpStatus(),MovieEnum.NOT_FOUND.getCode(),MovieEnum.NOT_FOUND.getMessage(), null,null);


        }

    }
    public MovieServiceResponse createMovie(Optional<MovieModel> movie) {
        if(movie.isPresent()) {
            return new MovieServiceResponse(MovieEnum.MOVIE_ALREADY_CREATED.getHttpStatus(),MovieEnum.MOVIE_ALREADY_CREATED.getCode(),MovieEnum.MOVIE_ALREADY_CREATED.getMessage(), movie.get());

        } else {
            return new MovieServiceResponse(MovieEnum.CREATED.getHttpStatus(),MovieEnum.CREATED.getCode(),MovieEnum.CREATED.getMessage(), null);


        }

    }

    public MovieServiceResponse exist(Optional<MovieModel> movie) {
        if(movie.isPresent()) {
            return new MovieServiceResponse(MovieEnum.OK.getHttpStatus(),MovieEnum.OK.getCode(),MovieEnum.OK.getMessage(), movie.get());


        } else {
            return new MovieServiceResponse(MovieEnum.NOT_FOUND.getHttpStatus(),MovieEnum.NOT_FOUND.getCode(),MovieEnum.NOT_FOUND.getMessage(), null);
        }

    }
    public MovieServiceResponse updateMovie(Optional<MovieModel> movie) {
        if(movie.isPresent()) {
            return new MovieServiceResponse(MovieEnum.OK.getHttpStatus(),MovieEnum.OK.getCode(),MovieEnum.OK.getMessage(), movie.get());


        } else {
            return new MovieServiceResponse(MovieEnum.NOT_FOUND.getHttpStatus(),MovieEnum.NOT_FOUND.getCode(),MovieEnum.NOT_FOUND.getMessage(), null);


        }

    }
    public MovieServiceResponse removeMovie(Optional<MovieModel> movie) {
        if(movie.isPresent()) {
            return new MovieServiceResponse(MovieEnum.OK.getHttpStatus(),MovieEnum.OK.getCode(),MovieEnum.OK.getMessage(), movie.get());

        } else {
            return new MovieServiceResponse(MovieEnum.NOT_FOUND.getHttpStatus(),MovieEnum.NOT_FOUND.getCode(),MovieEnum.NOT_FOUND.getMessage(), null);


        }

    }
}
