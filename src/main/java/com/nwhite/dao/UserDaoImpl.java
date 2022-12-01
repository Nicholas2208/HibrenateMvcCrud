package com.nwhite.dao;

import com.nwhite.model.User;

import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
        em.flush();
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(Long id) {
        User u = get(id);
        em.remove(u);
    }

    @Override
    public User get(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }
}
