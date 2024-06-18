package co.edu.poli.ces4.booking.persistence.repository;


import co.edu.poli.ces4.booking.persistence.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
