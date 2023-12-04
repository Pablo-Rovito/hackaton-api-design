package com.hackathon.equipo2.CineHackacthon.repositories;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    public List<MovieModel> findAll() {
        return CineHackacthonApplication.movies.stream().toList();
    }

    public Optional<MovieModel> findById(Long id) {
        Optional<MovieModel> movie = CineHackacthonApplication.movies.stream().filter(movieModel -> movieModel.getId().equals(id)).findFirst();
        if (movie.isPresent()) {
            return movie;
        } else return Optional.empty();
    }

    public MovieModel add(MovieModel movie) {
        CineHackacthonApplication.movies.add(movie);
        System.out.println(CineHackacthonApplication.movies);
        return movie;
    }

    public Optional<MovieModel> remove(Long id) {
        Optional<MovieModel> movie = this.findById(id);
        if (movie.isPresent()) {
            CineHackacthonApplication.movies.remove(movie.get());
            return movie;
        } else {
            return Optional.empty();
        }
    }

    public Optional<MovieModel> update(MovieModel movieModel) {

        Optional<MovieModel> movie = this.findById(movieModel.getId());
        if (movie.isPresent()) {
            CineHackacthonApplication.movies.set(CineHackacthonApplication.movies.indexOf(movie.get()), movieModel);
            return movie;
        } else return Optional.empty();
    }
}
