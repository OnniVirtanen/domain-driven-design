package com.paymentservice.demo.domain.repository;

import java.util.Optional;

public interface BaseRepository<T, ID> {

    T save(T object);
    Optional<T> findById(ID id);
    T update(T object);
    void deleteById(ID id);

}
