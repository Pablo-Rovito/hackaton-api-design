package com.hackathon.equipo2.CineHackacthon;

import com.hackathon.equipo2.CineHackacthon.models.MovieModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CineHackacthonApplication {

	public static ArrayList<MovieModel> movies = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(CineHackacthonApplication.class, args);
		moviesListExamples();
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

}
