package com.java.springxml.dao;

import com.java.springxml.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
