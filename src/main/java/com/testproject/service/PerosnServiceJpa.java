package com.testproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testproject.data.entities.Person;
import com.testproject.data.repository.PersonRepoJpa;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PerosnServiceJpa {

    @Autowired
    private PersonRepoJpa personRepoJpa;

    public Iterable<Person> findAllPersons(){
        return personRepoJpa.findAll();
    }

    public Person findPersonById(long id) {
        return personRepoJpa.findById(id).orElse(null);
    }

    public void removePersonById(long id){
        personRepoJpa.deleteById(id);
    }

    public void addPerson(Person person){
        personRepoJpa.save(person);
    }
    public void updatePerson(Person person){
        personRepoJpa.save(person);
    }
}
