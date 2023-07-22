package com.devedu.screenmatch.controllers;

import com.devedu.screenmatch.domain.movie.Movie;
import com.devedu.screenmatch.domain.movie.dto.MovieDTO;
import com.devedu.screenmatch.repositories.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/form")
    public String openFormPage(){
        return "movies/form";
    }

    @GetMapping
    public String openListPage(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "movies/list";
    }

    @PostMapping
    public String registerMovie(MovieDTO movieDTO) {
        var movie = new Movie();
        BeanUtils.copyProperties(movieDTO, movie);
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @DeleteMapping
    public String deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return "redirect:/movies";
    }
}
