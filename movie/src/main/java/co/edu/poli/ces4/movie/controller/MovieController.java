package co.edu.poli.ces4.movie.controller;

import co.edu.poli.ces4.movie.helper.Response;
import co.edu.poli.ces4.movie.helper.ResponseBuild;
import co.edu.poli.ces4.movie.persistence.entity.Movie;
import co.edu.poli.ces4.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(format(result));
        }
        service.save(movie);
        return build.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Movie movie = service.findById(id);
        service.delete(movie);
        return build.success(movie);
    }

    @GetMapping
    public Response findAll() {
        return build.success(service.findAll());
    }


    public Response findById(@PathVariable("id") Long id) {
        return build.success(service.findById(id));
    }

    private List<Map<String, String>> format(BindingResult result) {
        return result.getFieldErrors()
                .stream().map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
    }
}
