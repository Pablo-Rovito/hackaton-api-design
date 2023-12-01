package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public List<MovieModel> findAll() {

        return this.movieRepository.findAll();
    }

    public MovieModel findById(Long id) {


        return this.movieRepository.findById(id);
    }

    public Boolean add(MovieModel movie) {
        return this.movieRepository.add(movie);
    }

    public Boolean remove(Long id) {
        return this.movieRepository.remove(id);
    }

    public Boolean update(MovieModel movieModel) {
        return this.movieRepository.update(movieModel);
    }
}
