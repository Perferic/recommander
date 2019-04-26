package com.mouffronjo.recommander.service;

import com.mouffronjo.recommander.dao.FilmRepository;
import com.mouffronjo.recommander.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IService<Film>{

    @Autowired
    private FilmRepository filmDao;

    @Override
    public List<Film> getAll() {
        return filmDao.findAll();
    }

    @Override
    public Film getOneById(long id) {
        return filmDao.getOne(id);
    }

    @Override
    public Film getOneByTitle(String name) {
        return filmDao.findByTitle(name);
    }

    @Override
    public List<Film> search(String query) {
        return filmDao.findAllByTitle(query);
    }

    @Override
    public List<Film> getAllLimit(long startIndex, long limit) {
        return filmDao.findAll();
    }

    @Override
    public List<Film> searchLimit(String query, long startIndex, long limit) {
        return filmDao.findAllByTitle(query);
    }

    @Override
    public void create(Film entity) {
        filmDao.save(entity);
    }

    @Override
    public void edit(Film entity) {
        filmDao.save(entity);
    }

    @Override
    public void deleteById(long id) {
        filmDao.deleteById(id);
    }
}
