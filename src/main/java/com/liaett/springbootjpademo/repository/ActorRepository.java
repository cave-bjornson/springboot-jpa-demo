package com.liaett.springbootjpademo.repository;


import com.liaett.springbootjpademo.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor getActorByName(String name);
    List<Actor> getActorsByNameStartsWith(String namePart);
}
