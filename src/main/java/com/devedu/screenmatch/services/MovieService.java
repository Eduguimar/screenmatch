package com.devedu.screenmatch.services;

import com.devedu.screenmatch.domain.movie.Movie;
import com.devedu.screenmatch.domain.movie.dto.RegisterMovieDTO;
import com.devedu.screenmatch.repositories.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public Movie getById(Long id) {
        return repository.getReferenceById(id);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public void save(RegisterMovieDTO movieDTO) {
        var movie = new Movie();
        BeanUtils.copyProperties(movieDTO, movie);
        repository.save(movie);
    }

    public void updateMovie(Movie movie) {

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
