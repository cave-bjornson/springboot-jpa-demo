package com.liaett.springbootjpademo;

import com.liaett.springbootjpademo.entity.Actor;
import com.liaett.springbootjpademo.entity.Movie;
import com.liaett.springbootjpademo.repository.ActorRepository;
import com.liaett.springbootjpademo.repository.MovieRepository;
import com.liaett.springbootjpademo.service.ActorService;
import com.liaett.springbootjpademo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoRunner implements CommandLineRunner {
    /*
       Service and Repository classes and non recommended field injects
       mixed in just too show an example.
     */
    @Autowired
    MovieRepository movieRepository;
    final ActorRepository actorRepository;
    final MovieService movieService;
    @Autowired
    ActorService actorService;

    @Autowired // Not necessary
    public DemoRunner(MovieService movieService, ActorRepository actorRepository) {
        this.movieService = movieService;
        this.actorRepository = actorRepository;
    }

    @Override
    public void run(String... args) {
        List<Actor> aliensCast = actorService.getAllActors();
        Movie aliens = new Movie("Aliens", aliensCast);
        movieRepository.save(aliens);
        Movie movie = movieService.getMovieByTitle("Aliens");
        System.out.println(movieRepository.findAll());
        List<Actor> actors = actorRepository.getActorsByNameStartsWith("M");
        System.out.println(actors);
    }
}
