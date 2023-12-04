package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowValidatorModel;
import com.hackathon.equipo2.CineHackacthon.repositories.ShowRepository;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.ShowServiceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieService movieService;
//    @Autowired
//    RoomService roomService;

    public ShowServiceResponse<List<ShowModel>> findAll() {
        ShowServiceResponse<List<ShowModel>> responseService = new ShowServiceResponse<List<ShowModel>>();
        List<ShowModel> showList = this.showRepository.findAll();
        responseService.setEnum(ShowServiceEnum.SHOW_CALL_OK);
        responseService.setPayload(showList);

        // crear ShowRequestModel y ShowResponseModel ??
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
            responseService.setEnum(ShowServiceEnum.SHOW_CALL_OK);
            responseService.setPayload(showById.get());
        }

        return responseService;
    }

    public ShowServiceResponse<ShowModel> addShow(ShowModel show) {
        ShowModel result = new ShowModel();
        ShowServiceResponse<ShowModel> responseService = new ShowServiceResponse<ShowModel>(ShowServiceEnum.SHOW_CALL_ERROR, result);

        show.setShowId(this.showRepository.getNextId());

        ShowValidatorModel valid = this.canAddShow(show);

        MovieModel movie = this.movieService.findById(show.getMovie().getId());
        show.setMovie(movie);

//        RoomModel room = this.roomService.findById(show.getRoomModel().getId());


        ShowModel showAdded = this.showRepository.add(show);
        responseService.setEnum(ShowServiceEnum.SHOW_CALL_OK);
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
            responseService.setEnum(ShowServiceEnum.SHOW_CALL_OK);
        }
        return responseService;
    }


    private ShowValidatorModel canAddShow(ShowModel show) {

        // existe room
        // existe movie
        // solapa schedule

        return null;
    }



}
