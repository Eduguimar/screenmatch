package com.devedu.screenmatch.controllers;

import com.devedu.screenmatch.domain.movie.Movie;
import com.devedu.screenmatch.domain.movie.dto.MovieDTO;
import com.devedu.screenmatch.repositories.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String openFormPage(){
        return "movies/form";
    }

    @PostMapping
    public String registerMovie(MovieDTO movieDTO) {
        var movie = new Movie();
        BeanUtils.copyProperties(movieDTO, movie);
        movieRepository.addMovie(movie);
        System.out.println(movieRepository.getAllMovies());
        return "movies/form";
    }
}
