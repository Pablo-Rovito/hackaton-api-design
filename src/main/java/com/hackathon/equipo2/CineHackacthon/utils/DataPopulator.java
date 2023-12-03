package com.hackathon.equipo2.CineHackacthon.utils;

import com.hackathon.equipo2.CineHackacthon.models.SeatModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataPopulator {
    public static List<SeatModel> seatListGenerator(int rows, int columns, long roomId) {

        List<SeatModel> response = new ArrayList<>(rows * columns);
        long seatId = 0;

        for(int i = 1; i <= rows; i++) {

            for(int j = 1; j <= columns; j++) {
                SeatModel seat = new SeatModel();

                seat.setId(seatId);
                seat.setColumn(j);
                seat.setRow(i);
                seat.setRoomId(roomId);
                seat.setStatusCode(SeatStatusEnum.AVAILABLE);

                response.add(seat);
                seatId++;
            }
        }

        return response;
    }
}
