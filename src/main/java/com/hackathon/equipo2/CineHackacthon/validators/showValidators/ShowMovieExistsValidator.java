package com.hackathon.equipo2.CineHackacthon.validators.showValidators;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowValidatorModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketValidatorModel;
import com.hackathon.equipo2.CineHackacthon.services.MovieService;
import com.hackathon.equipo2.CineHackacthon.services.ShowService;
import com.hackathon.equipo2.CineHackacthon.services.responses.MovieServiceResponse;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShowMovieExistsValidator extends AbstractShowValidator {
    @Autowired
    MovieService movieService;
    @Autowired
    ShowService showService;

    @Override
    public ShowValidatorModel apply(ShowModel key) {
        return this.existsMovie(key);
    }

    public ShowValidatorModel existsMovie(ShowModel showModel) {

        boolean valid = true;
        ShowValidatorModel validation = new ShowValidatorModel(valid, ShowValidatorEnum.SHOW_VALID);


        ShowServiceResponse<ShowModel> showResponse = this.showService.findById(showModel.getShowId());
        if (!showResponse.getCode().equals(ShowServiceEnum.SHOW_CALL_OK.getCode())) {
            valid = false;
            validation = new ShowValidatorModel(valid, ShowValidatorEnum.SHOW_NOT_EXISTS);
            return validation;
        }


        MovieServiceResponse<MovieModel> response = this.movieService.findById(showModel.getMovie().getId());
        if (!response.getCode().equals(MovieEnum.OK.getCode())) {
            valid = false;
            validation = new ShowValidatorModel(valid, ShowValidatorEnum.SHOW_MOVIE_NOT_EXISTS);
        }

        return  validation;

    }

}
