package ru.kulakov.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kulakov.spring.Model.Director;
import ru.kulakov.spring.repositories.DirectorRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> findAll(){
        return directorRepository.findAll();
    }

    public Director findById(Integer id){
        Optional<Director> optional = directorRepository.findById(id);
        return optional.orElse(null);
    }

    public Director update(Integer id, Director updateDirector){
        updateDirector.setId(id);
        return directorRepository.save(updateDirector);
    }

    public void save(Director director){
        director.setCreatedAt(new Date());
        directorRepository.save(director);
    }

    public void delete(Integer id){
        directorRepository.deleteById(id);
    }
}
