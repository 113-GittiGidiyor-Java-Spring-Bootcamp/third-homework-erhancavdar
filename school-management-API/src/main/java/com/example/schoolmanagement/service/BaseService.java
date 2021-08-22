package com.example.schoolmanagement.service;

import java.util.List;

public interface BaseService <T>{
    List<T> findAll();

    T findById(long id);

    T save(T t);

    void delete(long id);

    void update(T t);
}
