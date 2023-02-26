package ru.kulakov.spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kulakov.spring.Model.Actor;
import ru.kulakov.spring.Model.Person;

import java.util.List;
import java.util.Optional;

@Component
public class ActorDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ActorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Actor> index() {
        return jdbcTemplate.query("SELECT * FROM actors", new BeanPropertyRowMapper<>(Actor.class));
    }

    public Actor show(int id) {
        return jdbcTemplate.query("SELECT * FROM actors WHERE actor_id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Actor.class))
                .stream().findAny().orElse(null);
    }

    public void save(Actor actor) {
        jdbcTemplate.update("INSERT INTO actors(name,age) VALUES (?,?)",actor.getName(),actor.getAge());
    }

    public void update(int id, Actor updateActor) {
        jdbcTemplate.update("UPDATE actors SET name=?,age=? WHERE actor_id=?",updateActor.getName(),updateActor.getAge(),id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM actors WHERE actor_id=?",id);

    }
}
