package com.hackathon.equipo2.CineHackacthon;


import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.utils.DataPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CineHackacthonApplication {


	public static List<TicketModel> tickets = new ArrayList<>();
	public static ArrayList<MovieModel> movies = new ArrayList<>();
	public static List<ShowModel> showModel = new ArrayList<ShowModel>();
	public static List<RoomModel> rooms;

	public static void main(String[] args) {
		SpringApplication.run(CineHackacthonApplication.class, args);
		moviesListExamples();
		CineHackacthonApplication.showModel = CineHackacthonApplication.getShowsModel();
		CineHackacthonApplication.tickets = CineHackacthonApplication.getBuyTicket();
		rooms = getRooms();
		System.out.println("Application initialized!");
	}

	public static List<TicketModel> getBuyTicket() {

		System.out.println("getBuyTicket");

		List<TicketModel> buyTickets = new ArrayList<>();

//		buyTickets.add(new TicketModel(new ShowModel(123,new RoomModel(),789,101),1,1,10.50));
//		buyTickets.add(new TicketModel(new ShowModel(987,654,789,321),2,2,11.50));
//		buyTickets.add(new TicketModel(new ShowModel(123,456,789,101),3,3,12.50));

		return buyTickets;
	}//getBuyTicket

	private static void moviesListExamples() {
		movies.add(
				new MovieModel(
						1L,
						"Interstellar",
						"Ciencia Ficcion sinopsis"

				)
		);

		movies.add(
				new MovieModel(
						2L,
						"Titanic",
						"Historia de amor sinopsis"

				)
		);

		movies.add(
				new MovieModel(
						3L,
						"Avatar",
						"Fantasia sinopsis"

				)
		);
	}

	private static List<ShowModel> getShowsModel() {
		List<ShowModel> showModels = new ArrayList<ShowModel>();
		showModels.add(new ShowModel(1l, null, 1l, 1l));


		return showModels;

	}

	private static List<RoomModel> getRooms() {
		List<RoomModel> rooms = new ArrayList<>();

		rooms.add(
				new RoomModel(0L, DataPopulator.seatListGenerator(5, 6, 0L))
		);

		rooms.add(
				new RoomModel(1L, DataPopulator.seatListGenerator(10, 10, 1L))
		);

		rooms.add(
				new RoomModel(2L, DataPopulator.seatListGenerator(15, 12, 2L))
		);

		return rooms;
	}

}
