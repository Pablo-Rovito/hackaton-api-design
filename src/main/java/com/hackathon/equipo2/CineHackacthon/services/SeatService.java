package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.services.responses.SeatServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.SeatEnum;
import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    ShowService showService;

    public SeatServiceResponse<List<SeatModel>> getSeats(long showId, SeatStatusEnum status) {
        SeatServiceResponse<List<SeatModel>> seatServiceResponse = new SeatServiceResponse<List<SeatModel>>();

        ShowModel showModel = showService.findById(showId).getPayload();

        List<SeatModel> seatModels = showModel.getRoomModel().getSeats();

        if(status != null) {
            seatModels = seatModels.stream()
                    .filter(seatModel -> seatModel.getStatusCode().equals(status))
                    .toList();
        }

        seatServiceResponse.setPayload(seatModels);
        seatServiceResponse.setCode(SeatEnum.OK.getCode());
        seatServiceResponse.setHttpStatus(SeatEnum.OK.getHttpStatus());
        seatServiceResponse.setMessage(SeatEnum.OK.getMessage());
        return seatServiceResponse;
    }

    public Optional<SeatModel> findById(long idSeat, long idShow) {
        return   showService
                .findById(idShow)
                .getPayload()
                .getRoomModel()
                .getSeats()
                .stream()
                .filter(seatModel -> seatModel.getId() == idSeat)
                .findFirst();
    }

    public void changeStatus(long idSeat, long idShow, SeatStatusEnum seatEnum) {
        SeatModel seatModel = findById(idSeat, idShow).get();
        seatModel.setStatusCode(seatEnum);
    }
}
