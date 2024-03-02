package com.testproject.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.testproject.data.entities.Person;

public interface PersonRepoJpa extends CrudRepository<Person, Long>{
    
    
}
