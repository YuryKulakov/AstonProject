package ru.kulakov.spring.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kulakov.spring.Model.Actor;
import java.util.List;

@Component
public class ActorDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ActorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Actor> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select a from Actor a", Actor.class).getResultList();
    }

    @Transactional
    public Actor show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Actor.class, id);
    }

    @Transactional
    public void save(Actor actor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(actor);
    }
    @Transactional
    public void update(int id, Actor updateActor) {
        Session session = sessionFactory.getCurrentSession();
        session.get(Actor.class,id).setAge(updateActor.getAge());
        session.get(Actor.class,id).setName(updateActor.getName());
    }
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Actor.class,id));
    }
}
