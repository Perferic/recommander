package com.mouffronjo.recommander.service;

import com.mouffronjo.recommander.dao.UserRepository;
import com.mouffronjo.recommander.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User> {

    @Autowired
    private UserRepository UserDao;

    @Override
    public List<User> getAll() {
        return UserDao.findAll();
    }

    @Override
    public User getOneById(long id) {
        return UserDao.getOne(id);
    }

    @Override
    public User getOneByTitle(String name) {
        return UserDao.findByUsername(name);
    }

    @Override
    public List<User> search(String query) {
        return UserDao.findAllByUsername(query);
    }

    @Override
    public List<User> getAllLimit(long startIndex, long limit) {
        return UserDao.findAll();
    }

    @Override
    public List<User> searchLimit(String query, long startIndex, long limit) {
        return UserDao.findAllByUsername(query);
    }

    @Override
    public void create(User entity) {
        UserDao.save(entity);
    }

    @Override
    public void edit(User entity) {
        UserDao.save(entity);
    }

    @Override
    public void deleteById(long id) {
        UserDao.deleteById(id);
    }
}
