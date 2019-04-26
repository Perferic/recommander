package com.mouffronjo.recommander.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T getOneById(long id);
    T getOneByTitle(String name);
    List<T> search(String query);
    List<T> getAllLimit(long startIndex, long limit);
    List<T> searchLimit(String query, long startIndex, long limit);

    void create(T entity);
    void edit(T entity);
    void deleteById(long id);
}
