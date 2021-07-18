package com.manhdd.crudthymeleaf.controller;

import com.manhdd.crudthymeleaf.model.Person;
import com.manhdd.crudthymeleaf.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("persons", personRepo.getAllPerson());
        return "index";
    }

    @GetMapping("/add")
    public String showAddPerson() {

        return "addperson";
    }

}
