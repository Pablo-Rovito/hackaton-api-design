package com.hackathon.equipo2.CineHackacthon;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CineHackacthonApplication {

	public static ArrayList<MovieModel> movies = new ArrayList<>();

	public static List<ShowModel> showModel = new ArrayList<ShowModel>();

	public static void main(String[] args) {
		SpringApplication.run(CineHackacthonApplication.class, args);
		moviesListExamples();
		CineHackacthonApplication.showModel = CineHackacthonApplication.getShowsModel();
		System.out.println("Application initialized!");
	}

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

}
