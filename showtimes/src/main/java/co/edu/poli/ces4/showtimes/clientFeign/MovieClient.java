package co.edu.poli.ces4.showtimes.clientFeign;

import co.edu.poli.ces4.showtimes.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie")
public interface MovieClient {

    @GetMapping("/api/v1/poli/movies/{id}")
    Movie getMovieById(@PathVariable("id") Long id);
}


