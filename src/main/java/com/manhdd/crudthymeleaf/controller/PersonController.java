package com.manhdd.crudthymeleaf.controller;

import com.manhdd.crudthymeleaf.model.Person;
import com.manhdd.crudthymeleaf.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/")
    public String hello(){
        return"hello";
    }

    //Api add person
    @PostMapping ("/add")
    public Person addPerson(@RequestBody Person person){
        return  personService.addPerson(person);
    }

    //Api update person
    @PutMapping("/update")
    public Person updatePerson(@RequestParam("id") long id, @RequestBody Person person ){
        return personService.updatePerson(id, person);
    }

    //Api delete person
    @DeleteMapping("/delete/{id}")
    public boolean deletePerson(@PathVariable("id") long id){
        return personService.deletePerson(id);
    }

    //Api get all person
    @GetMapping("/list")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
}
