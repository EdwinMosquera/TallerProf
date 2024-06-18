package co.edu.poli.ces4.movie.service;

import co.edu.poli.ces4.movie.persistence.entity.Movie;
import co.edu.poli.ces4.movie.service.DTO.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    void save(Movie movie);
    void deleteMovie(Long movieId);
    List<Movie> findAll();
    Movie getMovieById(Long id);

}
