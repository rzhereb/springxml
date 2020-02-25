package com.java.springxml.dao;

import com.java.springxml.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

//    @PersistenceContext
//    private EntityManager entityManager;


    @Autowired
    SessionFactory sessionFactory;

    public void saveUser(User user) {
//        entityManager.persist(user);
        sessionFactory.getCurrentSession().save(user);
    }


    public List<User> getAllUsers() {
//        return entityManager.createQuery("select u from User u", User.class).getResultList();
        return sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
