package com.java.springxml.service;

import com.java.springxml.entity.User;

import java.util.List;

public interface IUserService {

    void saveUser(User user);

    List<User> getAllUsers();
}
