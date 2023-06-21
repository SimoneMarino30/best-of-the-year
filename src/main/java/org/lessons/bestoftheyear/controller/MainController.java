package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.Movie;
import org.lessons.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String template(Model model) {
        String myName = "Simone";
        model.addAttribute("myName", myName); // Aggiungo alla mappa del model un attributo
        return "index";
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

    // private methods che crea una lista delle songs
    private List<Song> getBestSongs() {
        // Istanzio ogni song con titolo e id
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song(1, "Bohemian Rhapsody");
        Song song2 = new Song(2, "Another Brick in The Wall");
        Song song3 = new Song(3, "Still D.R.E.");
        Song song4 = new Song(4, "House of The Rising Sun");
        Song song5 = new Song(5, "Anthem Part Two");
        // aggiungo i titoli e l'id delle singole song all' arraylist songs
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        return songs;
    }

    @GetMapping("/movies") // rotta
    public List<Movie> movies(Model model) {
        // Richiamo tutti i movies
        List<Movie> movies = getBestMovies();
        // Istanzio la lista che contiene solo i titoli
        List<String> movieTitles = new ArrayList<>();
        // Ciclo per stampare i titoli dei movies con il metodo gettitle di Movie
        for(Movie movie : movies) {
            movieTitles.add(movie.getTitle());
        }
        // Tolgo le quadre dalla stampa con il metodo join e aggiungo una virgola come separatore
        String withoutBrackets = String.join(", " , movieTitles);
        // Stampo nel template
        model.addAttribute("movies", withoutBrackets);
        return movies;
    }

    @GetMapping("/songs") // rotta
    public List<Song> songs(Model model) {
        // Richiamo tutte le songs
        List<Song> songs = getBestSongs();
        // Istanzio array che contiene solo i titoli
        List<String> movieSongs = new ArrayList<>();
        // Ciclo per stampare i titoli delle songs con il metodo getTitle della classe Songs
        for(Song song : songs) {
            movieSongs.add(song.getTitle());
        }
        // Tolgo le quadre dalla stampa con il metodo join e aggiungo una virgola come separatore
        String withoutBrackets = String.join(", " , movieSongs);
        // Stampo nel template
        model.addAttribute("songs", withoutBrackets);
        return songs;
    }
}
