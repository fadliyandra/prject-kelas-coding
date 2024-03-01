package com.testproject.data.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class Person {

    private long id;

    @NotEmpty(message = "fisrt name harus ada")
    private String firstName;

    @NotEmpty(message = "last name harus ada")
    private String lastName;
    private int age;

    @NotEmpty(message = "email harus ada")
    @Email(message = "invalid email")
    private String email;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public Person(int id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    public Person() {
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
                + email + "]";
    }

    

   
    

    


}
