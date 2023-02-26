package ru.kulakov.spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kulakov.spring.Model.Director;
import java.util.List;

@Component
public class DirectorDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DirectorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Director> index() {
        return jdbcTemplate.query("SELECT * FROM Directors", new BeanPropertyRowMapper<>(Director.class));
    }

    public Director show(int id) {
        return jdbcTemplate.query("SELECT * FROM Directors WHERE director_id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Director.class))
                .stream().findAny().orElse(null);
    }

    public void save(Director director) {
        jdbcTemplate.update("INSERT INTO Directors(name,age) VALUES (?,?)",director.getName(),director.getAge());
    }

    public void update(int director_id, Director updateDirector) {
        jdbcTemplate.update("UPDATE Directors SET name=?,age=? WHERE director_id=?",updateDirector.getName(),updateDirector.getAge(),director_id);
    }

    public void delete(int director_id) {
        jdbcTemplate.update("DELETE FROM Directors WHERE director_id=?",director_id);

    }
}
