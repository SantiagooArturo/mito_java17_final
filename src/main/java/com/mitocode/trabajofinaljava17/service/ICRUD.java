package com.mitocode.trabajofinaljava17.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T, ID> {

    T save(T t) throws Exception;
    T update(T t, ID id) throws Exception;
    List<T> readAll() throws Exception;

    Optional<T> readById(ID id) throws Exception;

    void delete(ID id) throws Exception;
}
