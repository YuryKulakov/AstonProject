package ru.kulakov.spring.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kulakov.spring.Model.Director;

import java.util.List;

@Component
public class DirectorDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public DirectorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Director> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select d from Director d", Director.class).getResultList();
    }
    @Transactional
    public Director show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Director.class, id);
    }
    @Transactional
    public void save(Director director) {
        Session session = sessionFactory.getCurrentSession();
        session.save(director);
    }
    @Transactional
    public void update(int id, Director updateDirector) {
        Session session = sessionFactory.getCurrentSession();
        session.get(Director.class, id).setName(updateDirector.getName());
        session.get(Director.class, id).setAge(updateDirector.getAge());

    }
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Director.class, id));
    }
}
