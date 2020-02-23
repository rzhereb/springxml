package com.java.springxml.service;

import com.java.springxml.dao.IUserDao;
import com.java.springxml.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
