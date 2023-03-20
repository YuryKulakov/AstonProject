package ru.kulakov.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kulakov.spring.Model.Actor;
@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
