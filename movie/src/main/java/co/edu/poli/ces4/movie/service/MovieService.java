package co.edu.poli.ces4.movie.service;

import co.edu.poli.ces4.movie.persistence.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    void save(Movie movie);
    void delete(Movie movie);
    Movie findById(Long id);
}
