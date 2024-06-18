package co.edu.poli.ces4.showtimes.persistence.repository;


import co.edu.poli.ces4.showtimes.persistence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long>{
    boolean existsByMovieId(Long movieId);
}
