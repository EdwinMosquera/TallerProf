package co.edu.poli.ces4.booking.service;

import co.edu.poli.ces4.movie.persistence.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    void save(Movie user);
    void delete(Movie user);
    Movie findById(Long id);
}
