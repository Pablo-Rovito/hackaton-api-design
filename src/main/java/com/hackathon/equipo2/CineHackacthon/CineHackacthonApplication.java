package com.hackathon.equipo2.CineHackacthon;


import com.hackathon.equipo2.CineHackacthon.models.RoomModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.TicketModel;
import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CineHackacthonApplication {


	public static List<TicketModel> tickets = new ArrayList<>();
	public static ArrayList<MovieModel> movies = new ArrayList<>();


	public static void main(String[] args) {
		SpringApplication.run(CineHackacthonApplication.class, args);
		moviesListExamples();
		System.out.println("Application initialized!");

		CineHackacthonApplication.tickets = CineHackacthonApplication.getBuyTicket();

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

}
