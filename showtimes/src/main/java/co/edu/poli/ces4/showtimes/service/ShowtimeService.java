package co.edu.poli.ces4.showtimes.service;



import co.edu.poli.ces4.showtimes.persistence.entity.Showtime;
import co.edu.poli.ces4.showtimes.persistence.entity.ShowtimeDetails;

import java.util.List;

public interface ShowtimeService {
    Showtime createShowtime(Showtime showtime);
    ShowtimeDetails getShowtimeDetails(Long id);
    List<ShowtimeDetails> getAllShowtimesWithMovies();
    Showtime updateShowtime(Long showtimeId, Showtime updatedShowtime);
    boolean existsByMovieId(Long movieId);
}
