package com.hackathon.equipo2.CineHackacthon.repositories;

import com.hackathon.equipo2.CineHackacthon.CineHackacthonApplication;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ShowRepository {
    public List<ShowModel> findAll() {
        return CineHackacthonApplication.showModel;
    }

    public Optional<ShowModel> findById(Long id) {
        return CineHackacthonApplication.showModel.stream().filter(s -> s.getShowId() == id).findFirst();
    }

    public ShowModel add(ShowModel show) {
        CineHackacthonApplication.showModel.add(show);



        return show;
    }

    public boolean delete(Long id) {
        return CineHackacthonApplication.showModel.removeIf(s -> s.getShowId() == id);
    }


    public long getNextId() {
        long id = 0;
        for (ShowModel show: CineHackacthonApplication.showModel) {
            id = Math.max(show.getShowId(), id);
        }
        return id + 1;
    }

    public List<ShowModel> findByMovieId(Long movieId) {
        return CineHackacthonApplication.showModel.stream().filter(s -> Objects.equals(s.getMovie().getId(), movieId)).collect(Collectors.toList());

    }
}
