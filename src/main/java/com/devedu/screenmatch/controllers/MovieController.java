package com.devedu.screenmatch.controllers;

import com.devedu.screenmatch.domain.dto.MovieDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String openFormPage(){
        return "movies/form";
    }

    @PostMapping
    public String registerMovie(MovieDTO movieDTO) {
        System.out.println(movieDTO);
        return "movies/form";
    }
}
