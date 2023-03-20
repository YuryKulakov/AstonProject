package ru.kulakov.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kulakov.spring.Model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {

}
