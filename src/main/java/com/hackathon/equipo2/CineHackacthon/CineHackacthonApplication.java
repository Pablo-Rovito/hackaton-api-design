package com.hackathon.equipo2.CineHackacthon;


import com.hackathon.equipo2.CineHackacthon.models.*;
import com.hackathon.equipo2.CineHackacthon.utils.DataPopulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CineHackacthonApplication {


	public static List<TicketModel> tickets = new ArrayList<>();
	public static List<MovieModel> movies = new ArrayList<>();

	public static List<ShowModel> showModel = new ArrayList<ShowModel>();
	public static List<RoomModel> rooms;

	public static void main(String[] args) {
		SpringApplication.run(CineHackacthonApplication.class, args);
        System.out.println("Application initialized!");

		CineHackacthonApplication.movies = CineHackacthonApplication.moviesListExamples();
		rooms = getRooms();
		CineHackacthonApplication.showModel = CineHackacthonApplication.getShowsModel();
		CineHackacthonApplication.tickets = CineHackacthonApplication.getBuyTicket();
		System.out.println("Application initialized!");
	}

	public static List<TicketModel> getBuyTicket() {

		System.out.println("getBuyTicket");

		List<TicketModel> buyTickets = new ArrayList<>();

		buyTickets.add(new TicketModel(showModel.get(0), 1L,2L));

		return buyTickets;
	}//getBuyTicket

	private static List<MovieModel> moviesListExamples() {
		List<MovieModel> movies = new ArrayList<MovieModel>();
		movies.add(new MovieModel(
						1L,
						"Interstellar",
						"Ciencia Ficcion sinopsis"
				)
		);
		movies.add(new MovieModel(
						2L,
						"Titanic",
						"Historia de amor sinopsis"
				)
		);
		movies.add(new MovieModel(
						3L,
						"Avatar",
						"Fantasia sinopsis"

				)
		);
		return movies;
	}

	private static List<ShowModel> getShowsModel() {
		List<ShowModel> showModels = new ArrayList<ShowModel>();
		List<MovieModel> movies = CineHackacthonApplication.moviesListExamples();
		MovieModel movie = new MovieModel();
		Date dateStart = new Date();
		Date dateEnd = new Date();
		try {
			String dateStartS = "2023-12-01 18:00";
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dateStart = format.parse(dateStartS);

			String dateEndS = "2023-12-01 20:00";
			DateFormat formatEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dateEnd = formatEnd.parse(dateEndS);
		} catch (Exception e) {
			System.out.println(e.toString());
		}


		showModels.add(new ShowModel(1L
						, (rooms != null && !rooms.isEmpty()) ? rooms.get(0) : new RoomModel()
						//, new RoomModel()
						, movies.isEmpty() ? movie : movies.get(0)
						, new ScheduleModel(1L, dateStart,  dateEnd)
						, 10
				)
		);
		showModels.add(new ShowModel(2L
						, (rooms != null && rooms.size() > 1) ? rooms.get(1) : new RoomModel()
						//, new RoomModel()
						, movies.isEmpty() ? movie : movies.get(0)
						, new ScheduleModel(1L, dateStart,  dateEnd)
						, 10
				)
		);

		return showModels;

	}

	private static List<RoomModel> getRooms() {
		List<RoomModel> rooms = new ArrayList<>();

		rooms.add(
				new RoomModel(0L, DataPopulator.seatListGenerator(2, 2, 0L))
		);

		rooms.add(
				new RoomModel(1L, DataPopulator.seatListGenerator(1, 3, 1L))
		);

		rooms.add(
				new RoomModel(2L, DataPopulator.seatListGenerator(4, 1, 2L))
		);

		return rooms;
	}

}
