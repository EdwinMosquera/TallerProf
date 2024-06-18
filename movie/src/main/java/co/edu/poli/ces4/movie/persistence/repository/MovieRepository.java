package co.edu.poli.ces4.movie.persistence.repository;

import co.edu.poli.ces4.movie.persistence.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
