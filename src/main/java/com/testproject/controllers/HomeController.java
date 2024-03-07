package com.testproject.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testproject.data.entities.User;
import com.testproject.data.repository.UserRepo;
import com.testproject.dto.MessageData;
import com.testproject.service.UserServiceJpa;
import com.testproject.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserServiceJpa service;
    // private PersonService service;

        // public HomeController(){
        //     service = new PersonService();
        // }

        @GetMapping
        public String showindex(Model model){
        //PersonRepo repo = new PersonRepo();
        //PersonService service = new PersonService();
    
        model.addAttribute("users" ,service.findAllUsers());
            return "index";
        } 

        @GetMapping("/users/add")
        public String showAddUser(Model model){
            model.addAttribute("user", new User());
            return "add";
        }

        @PostMapping("/users/add")
        public String addUser( @Valid User user, BindingResult errors, Model model){
            //logic untuk save ke list perosn
            if (errors.hasErrors()) {

                MessageData messageData = new MessageData();
                for(ObjectError err : errors.getAllErrors()){
                    messageData.getMessages().add(err.getDefaultMessage());

                }
                model.addAttribute("ERROR", messageData);
            
                model.addAttribute("user", user);
                return "add";    
                
            }

            service.addUser(user);

            return "redirect:/";
        }

        @GetMapping("/users/edit/{id}")
        public String showEditUser(@PathVariable("id") long id, Model model) {
        User user = service.findUserById(id);
        model.addAttribute("user", user);
        return "edit"; 
    }

    @PostMapping("/users/edit")
    public String editUser(@Valid User user, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            MessageData messageData = new MessageData();
            for (ObjectError err : errors.getAllErrors()) {
                messageData.getMessages().add(err.getDefaultMessage());
            }
            model.addAttribute("ERROR", messageData);
            model.addAttribute("user", user);
            return "edit";
        }
        service.updateUser(user);
        return "redirect:/";
    }


        @GetMapping("/users/{id}")
        public String showDetailUser( Model model, @PathVariable("id") long id){
           model.addAttribute("user", service.findUserById(id));
            return "detail";
        }

        @GetMapping("/users/remove/{id}")
        public String removeUser(@PathVariable("id") long id){
            service.removeUserById(id);
            return "redirect:/";
        }
    }
    

