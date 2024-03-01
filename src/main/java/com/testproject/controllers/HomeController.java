package com.testproject.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.testproject.data.entities.Person;
import com.testproject.data.repository.PersonRepo;
import com.testproject.dto.MessageData;
import com.testproject.service.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {


    // @GetMapping
    // public String showindexPAge(Model model){

        
    //     return null;
    // }

    private PersonService service;

        public HomeController(){
            service = new PersonService();
        }

        @GetMapping
        public String showindex(Model model){
        //PersonRepo repo = new PersonRepo();
        //PersonService service = new PersonService();
    
        model.addAttribute("peoples" ,service.findAllPersons());
            return "index";
        } 

        @GetMapping("/persons/add")
        public String showAddperson(Model model){
            model.addAttribute("person", new Person());
            return "add";
        }

        @PostMapping("/persons/add")
        public String addPerson( @Valid Person person, BindingResult errors, Model model){
            //logic untuk save ke list perosn
            if (errors.hasErrors()) {

                MessageData messageData = new MessageData();
                for(ObjectError err : errors.getAllErrors()){
                    messageData.getMessages().add(err.getDefaultMessage());

                }
                model.addAttribute("ERROR", messageData);
            
                model.addAttribute("person", person);
                return "add";    
                
            }

            service.addPerson(person);

            return "redirect:/";
        }

        @GetMapping("/persons/edit/{id}")
        public String showEditPerson(@PathVariable("id") long id, Model model) {
        Person person = service.findPersonById(id);
        model.addAttribute("person", person);
        return "edit"; 
    }

    @PostMapping("/persons/edit")
    public String editPerson(@Valid Person person, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            MessageData messageData = new MessageData();
            for (ObjectError err : errors.getAllErrors()) {
                messageData.getMessages().add(err.getDefaultMessage());
            }
            model.addAttribute("ERROR", messageData);
            model.addAttribute("person", person);
            return "edit";
        }
        service.updatePerson(person);
        return "redirect:/";
    }


        @GetMapping("/persons/{id}")
        public String showDetaolerson( Model model, @PathVariable("id") int id){
           model.addAttribute("person", service.findPersonById(id));
            return "detail";
        }

        @GetMapping("/persons/remove/{id}")
        public String removePerson(@PathVariable("id") int id){
            service.removePersonById(id);
            return "redirect:/";
        }
    }
    

