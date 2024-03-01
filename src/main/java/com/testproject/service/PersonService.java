package com.testproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testproject.data.entities.Person;
import com.testproject.data.repository.PersonRepo;


public class PersonService {
     private PersonRepo repo;

    public PersonService(){
        repo = new PersonRepo();
    }

    public List<Person> findAllPersons(){
        return repo.getPersons();
    }

    public Person findPersonById(long id) {
        return repo.findPersonById(id);
    }

    public void removePersonById(int id){
        repo.removePersonById(id);
    }

    public void addPerson(Person person){
        repo.addPerson(person);
    }
    public void updatePerson(Person person){
        repo.updatePerson(person);
    }

   

}
