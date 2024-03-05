package com.paymentservice.demo.infrastructure.repositoryimpl;

import com.paymentservice.demo.domain.Person;
import com.paymentservice.demo.domain.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Person save(Person object) {
        return null;
    }

    @Override
    public Optional<Person> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Person update(Person object) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

}
