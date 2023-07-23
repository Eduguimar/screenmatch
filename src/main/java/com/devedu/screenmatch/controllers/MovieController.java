package com.devedu.screenmatch.controllers;

import com.devedu.screenmatch.domain.movie.dto.RegisterMovieDTO;
import com.devedu.screenmatch.domain.movie.dto.UpdateMovieDTO;
import com.devedu.screenmatch.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/form")
    public String openFormPage(Long id, Model model){
        if (id != null) {
            var movie = service.getById(id);
            model.addAttribute("movie", movie);
        }
        return "movies/form";
    }

    @GetMapping
    public String openListPage(Model model){
        model.addAttribute("movies", service.findAll());
        return "movies/list";
    }

    @PostMapping
    public String registerMovie(RegisterMovieDTO movieDTO) {
        service.save(movieDTO);
        return "redirect:/movies";
    }

    @PutMapping
    @Transactional
    public String updateMovie(UpdateMovieDTO movieDTO) {
        service.updateMovie(movieDTO);
        return "redirect:/movies";
    }

    @DeleteMapping
    public String deleteMovie(Long id) {
        service.delete(id);
        return "redirect:/movies";
    }
}
