package com.devedu.screenmatch.repositories;

import com.devedu.screenmatch.domain.movie.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class MovieRepository {

    private Set<Movie> movies;

    public MovieRepository() {
        movies = new HashSet<>();
    }

    public Set<Movie> getAllMovies() {
        return movies;
    }

    public Movie addMovie(Movie movie){
        movies.add(movie);
        return movie;
    }
}
