package com.liaett.springbootjpademo.service;

import com.liaett.springbootjpademo.entity.Actor;
import com.liaett.springbootjpademo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor getActorByName(String name) {
        return actorRepository.getActorByName(name);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }
}
