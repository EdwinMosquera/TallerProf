package co.edu.poli.ces4.booking.service;

import co.edu.poli.ces4.booking.clientFeign.MovieClient;
import co.edu.poli.ces4.booking.clientFeign.ShowtimeClient;
import co.edu.poli.ces4.booking.clientFeign.UserClient;

import co.edu.poli.ces4.booking.model.ShowtimeDetails;
import co.edu.poli.ces4.booking.model.User;
import co.edu.poli.ces4.booking.persistence.entity.Booking;
import co.edu.poli.ces4.booking.persistence.entity.BookingDetails;
import co.edu.poli.ces4.booking.persistence.entity.Movie;
import co.edu.poli.ces4.booking.persistence.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    @Autowired
    private  MovieClient movieClient;

    @Autowired
    private  ShowtimeClient showtimeClient;

    @Autowired
    private UserClient userClient;

    public Booking createBooking(Long bookingId,Long userId, Long showtimeId, Long movieId){
        User user = userClient.getUserById(userId);
        if (user == null){
            throw new RuntimeException("no se encontro un usuario");
        }

        ShowtimeDetails showtime = showtimeClient.getShowtimeDetails(showtimeId);
        if (showtime == null) {
            throw new RuntimeException("Showtime not found");
        }

        // Validar Movie
        Movie movie = movieClient.getMovieById(movieId);
        if (movie == null) {
            throw new RuntimeException("Movie not found");
        }

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShowtimeId(showtimeId);
        booking.setMovieId(movieId);
        return bookingRepository.save(booking);


    }

    @Override
    public BookingDetails getBookingsDetails(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("no se encontro un booking"));
        Movie movie = movieClient.getMovieById(booking.getId());
        User user = userClient.getUserById(booking.getId());
        ShowtimeDetails showtimeDetails = showtimeClient.getShowtimeDetails(booking.getId());

        return new BookingDetails(booking.getId(), booking.getUserId(), booking.getShowtimeId(), booking.getMovieId(), movie.getTitle(), movie.getDirector(), (double) movie.getRating());
    }

    @Override
    public List<BookingDetails> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(booking ->{
                    Movie movie = movieClient.getMovieById(booking.getId());
                    User user = userClient.getUserById(booking.getId());
                    ShowtimeDetails showtimeDetails = showtimeClient.getShowtimeDetails(booking.getId());
                    return new BookingDetails(booking.getId(), booking.getUserId(), booking.getShowtimeId(), booking.getMovieId(), movie.getTitle(), movie.getDirector(), (double) movie.getRating());
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public Boolean existsByMovieId(Long movieId) {
        return bookingRepository.existsByMovieId(movieId);
    }

    @Override
    public Boolean existsByUserId(Long userId) {
        return bookingRepository.existsByUserId(userId);
    }

}
