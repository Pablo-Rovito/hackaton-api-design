package com.hackathon.equipo2.CineHackacthon.validators.showValidators;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowValidatorModel;
import com.hackathon.equipo2.CineHackacthon.services.MovieService;
import com.hackathon.equipo2.CineHackacthon.utils.RoomEnum;
import com.hackathon.equipo2.CineHackacthon.utils.ShowValidatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShowMovieExistsValidator extends AbstractShowValidator {
    @Autowired
    MovieService movieService;

    @Override
    public ShowValidatorModel apply(ShowModel key) {
        return this.existsMovie(key);
    }

    public ShowValidatorModel existsMovie(ShowModel showModel) {

        boolean valid = true;
        ShowValidatorModel validation = new ShowValidatorModel(valid, ShowValidatorEnum.SHOW_VALID);

//        MovieServiceResponse response = this.movieService.findById(showModel.getShowId());
//        if (!resposne.getCode().equals(RoomEnum.OK.getCode())) {
//            validation = new ShowValidatorModel(valid, ShowValidatorEnum.SHOW_MOVIE_NOT_EXISTS);
//        }

        return  validation;

    }

}
