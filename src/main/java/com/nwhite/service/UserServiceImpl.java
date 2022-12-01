package com.nwhite.service;

import com.nwhite.dao.UserDao;
import com.nwhite.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    @Override
    public User getUser(Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
