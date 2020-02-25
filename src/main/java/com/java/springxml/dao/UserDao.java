package com.java.springxml.dao;

import com.java.springxml.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

//    @PersistenceContext
//    private EntityManager entityManager;

//
//    @Autowired
//    SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;

    public void saveUser(User user) {
//        entityManager.persist(user);
//        sessionFactory.getCurrentSession().save(user);
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER (NAME, AGE) " +
                    "VALUES (?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<User> getAllUsers() {
//        return entityManager.createQuery("select u from User u", User.class).getResultList();
        try {
            Connection connection = dataSource.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM USER");
            List<User> users = new ArrayList<User>();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("age"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<User>();
        }
    }
}
