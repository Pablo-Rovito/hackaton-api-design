package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    
    @Autowired
    ShowRepository showRepository;

    public List<ShowModel> findAll() {
        List<ShowModel> result = this.showRepository.findAll();
        return result;
    }


    public Optional<ShowModel> findById(Long id) {
        if (id == null) {
            id = -1l;
        }
        return this.showRepository.findById(id);
    }

    public ShowModel addShow(ShowModel show) {
        return this.showRepository.add(show);
    }

    public ShowModel deleteShow(Long id) {
        Optional<ShowModel> showModel = this.findById(id);
        ShowModel result = new ShowModel();
        if (showModel.isEmpty()) {
            return result;
        }
        boolean isDeleted = this.showRepository.delete(id);
        if (isDeleted) {
            result = showModel.get();
        }
        return result;
    }



}
