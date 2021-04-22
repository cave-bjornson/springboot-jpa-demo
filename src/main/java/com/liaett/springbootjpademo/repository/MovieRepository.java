package com.liaett.springbootjpademo.repository;

import com.liaett.springbootjpademo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie getMovieByTitle(String title);
}
