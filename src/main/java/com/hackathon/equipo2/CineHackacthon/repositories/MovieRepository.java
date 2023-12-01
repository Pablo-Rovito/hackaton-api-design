package com.hackathon.equipo2.CineHackacthon.repositories;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    public List<MovieModel> findAll() {
        return CineHackacthonApplication.movies;
    }

    public MovieModel findById(Long id) {
        Optional<MovieModel> movie = CineHackacthonApplication.movies.stream().filter(movieModel -> movieModel.getId().equals(id)).findFirst();
        if (movie.isPresent()) {
            return movie.get();
        } else return null;
    }

    public Boolean add(MovieModel movie) {
        return CineHackacthonApplication.movies.add(movie);
    }

    public Boolean remove(Long id) {
        MovieModel movie = this.findById(id);
        return CineHackacthonApplication.movies.remove(movie);
    }

    public Boolean update(MovieModel movieModel) {

        MovieModel movie = this.findById(movieModel.getId());
        if(movie != null) {
            CineHackacthonApplication.movies.set(CineHackacthonApplication.movies.indexOf(movie),
                    movieModel
            );
            return true;
        } else return false;
    }
}
