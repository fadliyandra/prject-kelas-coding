package com.testproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testproject.data.entities.User;
import com.testproject.data.repository.UserRepo;


public class UserService {
     private UserRepo repo;

    public UserService(){
        repo = new UserRepo();
    }

    public List<User> findAllUsers(){
        return repo.getUsers();
    }

    public User findUserById(long id) {
        return repo.findUserById(id);
    }

    public void removeUserById(int id){
        repo.removeUserById(id);
    }

    public void addUser(User user){
        repo.addUser(user);
    }
    public void updateUser(User user){
        repo.updateUser(user);
    }

   

}
