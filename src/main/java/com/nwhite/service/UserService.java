package com.nwhite.service;

import com.nwhite.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUsers();
}
