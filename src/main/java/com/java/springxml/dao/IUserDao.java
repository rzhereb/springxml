package com.java.springxml.dao;

import com.java.springxml.entity.User;

import java.util.List;

public interface IUserDao {

    void saveUser(User user);

    List<User> getAllUsers();
}
