package com.testproject.data.repository;

import java.util.ArrayList;
import java.util.List;

import com.testproject.data.entities.Person;

public class PersonRepo {
    private List <Person> persons = new ArrayList<>();

    
    public PersonRepo(){
        persons.add(new Person(1, "fadlid", "yandrbva",23,"fad@gmail.com"));
        persons.add(new Person(2, "fadlids", "yandsrasf",23,"fad@gmail.com"));
        persons.add(new Person(3, "fadlissf", "yanvsdra",23,"fad@gmail.com"));
        persons.add(new Person(4, "fadlisf", "yandvsra",23,"fad@gmail.com"));

    }
        public List<Person> getPersons(){
            return persons;
        }

        public Person findPersonById(long id) {
            for (Person person : persons) {
                if (person.getId() == id) {
                    return person;
                }
            }
            return null;
        } 
        public void removePersonById(int id){
            persons.removeIf(pc -> pc.getId() == id);
        //    for(Person person : persons){
        //     if (person.getId() == id) {
        //         persons.remove(person);
        //         break;
        //     }
        //    }
        }

        public void addPerson(Person person){
            long nextId = persons.size() + 1;
            person.setId(nextId);
            persons.add(person);
        }

        public void updatePerson(Person person){
            for(Person p : persons){
                if (p.getId() == person.getId()) {
                    p.setFirstName(person.getFirstName());
                    p.setLastName(person.getLastName());
                    p.setAge(person.getAge());
                    p.setEmail(person.getEmail());
                    break;
                    
                }
            }
        }


    
        
    }

