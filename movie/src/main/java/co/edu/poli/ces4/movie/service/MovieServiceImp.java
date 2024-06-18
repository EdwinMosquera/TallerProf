package co.edu.poli.ces4.movie.service;

import co.edu.poli.ces4.movie.persistence.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService{
    @Override
    public List<Movie> findAll() {
        return List.of();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movie movie) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movie movie) {

    }

    @Override
    public Movie findById(Long id) {
        return null;
    }
}
