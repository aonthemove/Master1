package com.company.mockitomovie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> searchMyMovie(int id, String name) {
        List<Movie> myMovies = movieRepo.getUserMovieList(id);
        return myMovies.stream()
                .filter(movie -> movie.getName().contains(name))
                .collect(Collectors.toList());
    }
}
