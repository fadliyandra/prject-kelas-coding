package com.testproject.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.testproject.data.entities.User;

public interface UserRepoJpa extends CrudRepository<User, Long>{
    
    
}
