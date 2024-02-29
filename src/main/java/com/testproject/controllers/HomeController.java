package com.testproject.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testproject.data.entities.Person;
import com.testproject.data.repository.PersonRepo;
import com.testproject.service.PersonService;

@Controller
@RequestMapping("/")
public class HomeController {


    // @GetMapping
    // public String showindexPAge(Model model){

        
    //     return null;
    // }

    @GetMapping
    public String showindex(Model model){
        //PersonRepo repo = new PersonRepo();
        PersonService service = new PersonService();
    
        model.addAttribute("peoples" ,service.findAllPersons());
            return "index";
        } 
    }
    

