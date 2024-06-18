package co.edu.poli.ces4.showtimes.model;


import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String director;
    private Double rating;
}
