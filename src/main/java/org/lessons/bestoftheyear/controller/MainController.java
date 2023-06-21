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
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String template(Model model) {
        String myName = "Simone";
        model.addAttribute("myName", myName); // Aggiungo alla mappa del model un attributo
        return "index";
    }
}
