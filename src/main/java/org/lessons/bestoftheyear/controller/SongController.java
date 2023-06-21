package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping // rotta
    public List<Song> songs(Model model) {
        // Richiamo tutte le songs
        List<Song> songs = getBestSongs();
        // DAY 1
        // Istanzio array che contiene solo i titoli
        //List<String> songsTitle = new ArrayList<>();
        // Ciclo per stampare i titoli delle songs con il metodo getTitle della classe Songs
        /*for(Song song : songs) {
            songsTitle.add(song.getTitle());
        }*/
        // Tolgo le quadre dalla stampa con il metodo join e aggiungo una virgola come separatore
        //String withoutBrackets = String.join(", " , songsTitle);
        // Stampo nel template
        //model.addAttribute("songs", withoutBrackets);

        // DAY2 = ritorno una lista di oggetti
        model.addAttribute("songs", songs);
        return songs;
    }

    // Pagina dettaglio
    @GetMapping("/{id}")
    public String songDetail(@PathVariable int id, Model model){
        // Recupero l' ID
        Song song = null;
        for(Song s : getBestSongs()) {
            if(s.getId() == id) {
                song = s;
            }
        }
        // Aggiungo
        model.addAttribute("song", song);
        return "songDetail";

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
}
