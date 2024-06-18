package co.edu.poli.ces4.showtimes.service;

import co.edu.poli.ces4.showtimes.persistence.entity.Showtime;

import java.util.List;

public interface ShowtimeService {
    List<Showtime> findAll();
    void save(Showtime showtime);
    void delete(Showtime showtime);
    Showtime findById(Long id);
}
