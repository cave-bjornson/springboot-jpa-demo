package com.liaett.springbootjpademo.service;

import com.liaett.springbootjpademo.entity.Actor;
import com.liaett.springbootjpademo.entity.Movie;
import com.liaett.springbootjpademo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieByTitle(String title) {
        return movieRepository.getMovieByTitle(title);
    }

    public void addActorToMovie(Actor actor, String title) {
        Movie movie = movieRepository.getMovieByTitle(title);
        movie.getCast().add(actor);
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(String title) {
        Movie movie = movieRepository.getMovieByTitle(title);
        movieRepository.delete(movie);
    }
}
