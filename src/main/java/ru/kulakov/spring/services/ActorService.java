package ru.kulakov.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kulakov.spring.Model.Actor;
import ru.kulakov.spring.repositories.ActorRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    public Actor findById(Integer id){
        Optional<Actor> optional = actorRepository.findById(id);
        return optional.orElse(null);
    }
    @Transactional
    public void save(Actor actor){
        actor.setCreatedAt(new Date());
        actorRepository.save(actor);
    }

    @Transactional
    public void update(Integer id, Actor updateActor){
        updateActor.setId(id);
        actorRepository.save(updateActor);
    }

    @Transactional
    public void delete(Integer id){
        actorRepository.deleteById(id);
    }
}
