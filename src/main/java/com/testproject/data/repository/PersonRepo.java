package com.testproject.data.repository;

import java.util.ArrayList;
import java.util.List;

import com.testproject.data.entities.Person;

public class PersonRepo {
    private List <Person> person = new ArrayList<>();

    
    public PersonRepo(){
        person.add(new Person(1, "fadlid", "yandrbva",23,"fad@gmail.com"));
        person.add(new Person(2, "fadlids", "yandsrasf",23,"fad@gmail.com"));
        person.add(new Person(3, "fadlissf", "yanvsdra",23,"fad@gmail.com"));
        person.add(new Person(4, "fadlisf", "yandvsra",23,"fad@gmail.com"));

    }
        public List<Person> getPersons(){
            return person;
        }

    }

