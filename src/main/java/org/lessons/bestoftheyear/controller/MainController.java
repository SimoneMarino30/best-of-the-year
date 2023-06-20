package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.Movie;
import org.lessons.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String template(Model model) {
        String myName = "Simone Marino";
        model.addAttribute("myName", myName); // Aggiungo alla mappa del model un attributo
        return "index";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie(1, "Fear and Loating in Las Vegas");
        Movie movie2 = new Movie(2, "Goodfellas");
        Movie movie3 = new Movie(3, "Into the Wild");
        Movie movie4 = new Movie(4, "Pulp Fiction");
        Movie movie5 = new Movie(5, "Reservoir Dogs");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song(1, "Bohemian Rhapsody");
        Song song2 = new Song(2, "Smells Like Teen Spiri");
        Song song3 = new Song(3, "Still D.R.E.");
        Song song4 = new Song(4, "House of The Rising Sun");
        Song song5 = new Song(5, "White Rabbit");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        return songs;
    }
}
