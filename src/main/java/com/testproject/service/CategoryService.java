package com.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testproject.data.entities.Category;
import com.testproject.data.repository.CategoryRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepo repo;

    public Iterable<Category> findAllCategories(){
        return repo.findAll();
    }

    public Category findCategoryById(long id){
        return repo.findById(id).orElse(null);
    }

    public void removeCategoryById(long id){
        repo.deleteById(id);

    }

    public Category addCatgeory(Category category){

        return repo.save(category);

    }
    
    public Category updateCategory(Category category){

        return repo.save(category);
    }



    
}
