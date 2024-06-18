package co.edu.poli.ces4.showtimes.service;

import co.edu.poli.ces4.showtimes.persistence.entity.Showtime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImp implements ShowtimeService {
    @Override
    public List<Showtime> findAll() {
        return List.of();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Showtime showtime) {

    }

    @Override
    public Showtime findById(Long id) {
        return null;
    }
}
