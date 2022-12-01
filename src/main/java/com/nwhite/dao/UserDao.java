package com.nwhite.dao;

import com.nwhite.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void update(User user);
    void delete(Long id);
    User get(Long id);
    List<User> getAll();
}
