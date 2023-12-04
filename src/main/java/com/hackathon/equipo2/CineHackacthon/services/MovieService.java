package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.repositories.MovieRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.MovieServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.MovieEnum;
import com.hackathon.equipo2.CineHackacthon.validators.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieValidator movieValidator;


    public MovieServiceResponse<List<MovieModel>> findAll() {
        MovieServiceResponse<List<MovieModel>> response = movieValidator.existMovieList(this.movieRepository.findAll());
        if(response.getHttpStatus() == MovieEnum.OK.getHttpStatus()) {
            response.setMovies(this.movieRepository.findAll());
        }
        return response;
    }

    public MovieServiceResponse<MovieModel> findById(Long id) {
        MovieServiceResponse<MovieModel> response = movieValidator.exist(this.movieRepository.findById(id));
        return response;

    }

    public MovieServiceResponse<MovieModel> add(MovieModel movie) {
        MovieServiceResponse<MovieModel> response = movieValidator.createMovie(this.movieRepository.findById(movie.getId()), movie);
        System.out.println(response.getHttpStatus());
        if(response.getHttpStatus() == MovieEnum.CREATED.getHttpStatus()){
            this.movieRepository.add(movie);
        }
        return response;

    }

    public MovieServiceResponse<MovieModel> remove(Long id) {
        MovieServiceResponse<MovieModel> response = movieValidator.removeMovie(this.movieRepository.findById(id));
        if(response.getHttpStatus() == MovieEnum.OK.getHttpStatus()) {
             this.movieRepository.remove(id);
        }
        return response;
    }

    public MovieServiceResponse<MovieModel> update(MovieModel movieModel) {
        MovieServiceResponse<MovieModel> response = movieValidator.updateMovie(this.movieRepository.findById(movieModel.getId()));
        if(response.getHttpStatus() == MovieEnum.OK.getHttpStatus()){
            this.movieRepository.update(movieModel);
        }
        return response;
    }
}
