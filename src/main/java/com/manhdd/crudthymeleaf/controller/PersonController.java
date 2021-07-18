package com.manhdd.crudthymeleaf.controller;

import com.manhdd.crudthymeleaf.model.Person;
import com.manhdd.crudthymeleaf.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("persons", personRepo.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddPerson() {

        return "addperson";
    }

    @GetMapping(value = "/{id}")
    public String getByID(@PathVariable("id") int id, Model model) {
        Optional<Person> book = personRepo.get(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        }
        return "index";
    }
}
