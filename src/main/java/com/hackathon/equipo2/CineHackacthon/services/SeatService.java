package com.hackathon.equipo2.CineHackacthon.services;

import com.hackathon.equipo2.CineHackacthon.utils.SeatStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    ShowService showService;

    public SeatServiceResponse getSeats(long showId, SeatStatusEnum status) {
        SeatServiceResponse seatServiceResponse = new SeatServiceResponse();
//
//        Optional<ShowModel> optionalShowModel = showService.findById(showId);
//        ShowModel showModel = optionalShowModel.get();
//
//        List<SeatModel> seatModels = showModel.getRoomModel().getSeats();
//
//        if(status != null) {
//            seatModels = seatModels.stream()
//                    .filter(seatModel -> seatModel.getStatusCode().equals(status))
//                    .toList();
//        }
//
//        seatServiceResponse.setSeatModels(seatModels);
        return seatServiceResponse;
    }
}
