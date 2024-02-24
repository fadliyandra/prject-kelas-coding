package com.testproject.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testproject.models.Person;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showindex(Model model){
        Date date = new Date();
        model.addAttribute("serverTime", date);

        Person p1 = new Person();
        p1.setFirstName("fadliiii");
        p1.setLastName("yandra");
        p1.setAge(30);
        p1.setEmail("fadlia@ymail.com");
        Person p2 = new Person("fadli", "yandra", 30, "fadlyandra@ymai.com");
        Person p3 = new Person("fadli1", "yandra1", 310, "fadlyandra1@ymai.com");
        
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("peoples", people);
            return "index";
        } 
    }
    

