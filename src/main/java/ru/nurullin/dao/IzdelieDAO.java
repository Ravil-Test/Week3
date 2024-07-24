package ru.nurullin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.nurullin.models.Izdelie;

import java.util.List;

@Component
public class IzdelieDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public IzdelieDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Izdelie> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Izdelie p", Izdelie.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Izdelie show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Izdelie.class, id);
    }

    @Transactional
    public void save(Izdelie izdelie) {
        Session session = sessionFactory.getCurrentSession();
        session.save(izdelie);
    }

    @Transactional
    public void update(int id, Izdelie updatedIzdelie) {
        Session session = sessionFactory.getCurrentSession();
        Izdelie izdelieToBeUpdated = session.get(Izdelie.class, id);

        izdelieToBeUpdated.setName(updatedIzdelie.getName());
        izdelieToBeUpdated.setPrice(updatedIzdelie.getPrice());
        izdelieToBeUpdated.setCalories(updatedIzdelie.getCalories());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Izdelie.class, id));
    }
}