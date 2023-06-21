package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.Movie;
import org.lessons.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @GetMapping // rotta
    public List<Movie> movies(Model model) {
        // Richiamo tutti i movies
        List<Movie> movies = getBestMovies();

        // Istanzio la lista che contiene solo i titoli
        //List<String> movieTitles = new ArrayList<>();
        // Ciclo per stampare i titoli dei movies con il metodo gettitle di Movie
        /*for(Movie movie : movies) {
            movieTitles.add(movie.getTitle());
        }*/
        // Tolgo le quadre dalla stampa con il metodo join e aggiungo una virgola come separatore
        //String withoutBrackets = String.join(", " , movieTitles);
        // Stampo nel template
        //model.addAttribute("movies", withoutBrackets);

        // DAY2 = ritorno una lista di oggetti
        model.addAttribute("movies", movies);
        return movies;
    }

    // Pagina dettaglio
    @GetMapping("/{id}")
    public String movieDetail(@PathVariable int id, Model model){
        // Recupero l' ID
        Movie movie = null;
        for(Movie m : getBestMovies()) {
            if(m.getId() == id) { // Controllo se l'ID del movie corrente coincide con l'ID fornito come parametro
                movie = m; // Assegno l'oggetto "m" a "movie" se l'ID coincide
            }
        }
        // Aggiungo l'oggetto "movie" all'oggetto "model" per renderlo disponibile nella vista
        model.addAttribute("movie", movie);
        return "movieDetail"; // ritorno la vista detail

    }

    // private methods che crea una lista di movies
    private List<Movie> getBestMovies() {
        // Nuova lista di movies
        List<Movie> movies = new ArrayList<>();
        // Istanzio ogni movie con titolo e id
        Movie movie1 = new Movie(1, "Fear and Loating in Las Vegas");
        Movie movie2 = new Movie(2, "Goodfellas");
        Movie movie3 = new Movie(3, "Into the Wild");
        Movie movie4 = new Movie(4, "Pulp Fiction");
        Movie movie5 = new Movie(5, "Reservoir Dogs");
        // aggiungo i titoli e l'id dei singoli movie all' arraylist movies
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        return movies;
    }
}
