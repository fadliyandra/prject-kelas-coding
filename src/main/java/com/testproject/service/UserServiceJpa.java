package com.testproject.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testproject.data.entities.User;
import com.testproject.data.repository.UserRepoJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceJpa {

    @Autowired
    private UserRepoJpa personRepoJpa;

    public Iterable<User> findAllUsers(){
        return personRepoJpa.findAll();
    }

    public User findUserById(long id) {
        return personRepoJpa.findById(id).orElse(null);
    }

    public void removeUserById(long id){
        personRepoJpa.deleteById(id);
    }

    public void addUser(User user){
        personRepoJpa.save(user);
    }
    public void updateUser(User user){
        personRepoJpa.save(user);
    }
}
