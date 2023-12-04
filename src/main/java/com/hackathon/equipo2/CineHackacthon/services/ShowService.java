package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowValidatorModel;
import com.hackathon.equipo2.CineHackacthon.repositories.ShowRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.MovieServiceResponse;
import com.hackathon.equipo2.CineHackacthon.services.responses.RoomServiceResponse;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.ShowServiceEnum;
import com.hackathon.equipo2.CineHackacthon.validators.showValidators.ShowMovieExistsValidator;
import com.hackathon.equipo2.CineHackacthon.validators.showValidators.ShowRoomExistsValidator;
import com.hackathon.equipo2.CineHackacthon.validators.showValidators.ShowScheduleOverlapValidator;
import com.hackathon.equipo2.CineHackacthon.validators.showValidators.AbstractShowValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieService movieService;
    @Autowired
    RoomService roomService;
    @Autowired
    ShowMovieExistsValidator movieExistsValidator;
    @Autowired
    ShowRoomExistsValidator roomExistsValidator;

    @Autowired
    ShowScheduleOverlapValidator overlapValidator;

    List<AbstractShowValidator> validators;

    public ShowServiceResponse<List<ShowModel>> findAll() {
        ShowServiceResponse<List<ShowModel>> responseService = new ShowServiceResponse<List<ShowModel>>();
        List<ShowModel> showList = this.showRepository.findAll();
        responseService.setShowServiceEnum(ShowServiceEnum.SHOW_CALL_OK);
        responseService.setPayload(showList);

        return responseService;
    }


    public ShowServiceResponse<ShowModel> findById(Long id) {

        ShowModel show = new ShowModel();
        ShowServiceResponse<ShowModel> responseService = new ShowServiceResponse<ShowModel>(ShowServiceEnum.SHOW_CALL_ERROR, show);
        if (id == null) {
            id = -1l;
        }

        Optional<ShowModel> showById = this.showRepository.findById(id);
        if (showById.isPresent()) {
            responseService.setShowServiceEnum(ShowServiceEnum.SHOW_CALL_OK);
            responseService.setPayload(showById.get());
        }

        return responseService;
    }

    public ShowServiceResponse<ShowModel> addShow(ShowModel show) {
        ShowModel result = new ShowModel();
        ShowServiceResponse<ShowModel> responseService = new ShowServiceResponse<ShowModel>(ShowServiceEnum.SHOW_CALL_ERROR, result);

        show.setShowId(this.showRepository.getNextId());

        validators = new ArrayList<AbstractShowValidator>();
        validators.add(movieExistsValidator);
        validators.add(roomExistsValidator);
        validators.add(overlapValidator);
        for (AbstractShowValidator validator: this.validators) {
            ShowValidatorModel valid = validator.apply(show);
            if (!valid.isValid()) {
                responseService.setShowValidatorEnum(valid.getShowValidatorEnum());
                return responseService;
            }
        }

        MovieServiceResponse<MovieModel> movie = this.movieService.findById(show.getMovie().getId());
        show.setMovie(movie.getPayload());

        RoomServiceResponse<RoomModel> room = this.roomService.findById(show.getRoomModel().getId());
        show.setRoomModel(room.getPayload());

        ShowModel showAdded = this.showRepository.add(show);
        responseService.setShowServiceEnum(ShowServiceEnum.SHOW_CALL_OK);
        responseService.setPayload(showAdded);

        return  responseService;
    }



    public ShowServiceResponse<ShowModel> deleteShow(Long id) {

        ShowModel result = new ShowModel();
        ShowServiceResponse<ShowModel> responseService = new ShowServiceResponse<ShowModel>(ShowServiceEnum.SHOW_CALL_ERROR, result);
        ShowServiceResponse<ShowModel> showResponse = this.findById(id);

        ShowModel showModel = showResponse.getPayload();

        if (!showResponse.getCode().equals(ShowServiceEnum.SHOW_CALL_OK.getCode())) {
            return responseService;
        }
        boolean isDeleted = this.showRepository.delete(id);
        if (isDeleted) {
            responseService.setPayload(showModel);
            responseService.setShowServiceEnum(ShowServiceEnum.SHOW_CALL_OK);
        }
        return responseService;
    }




}
