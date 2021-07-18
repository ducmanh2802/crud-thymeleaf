package com.manhdd.crudthymeleaf.repository;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.manhdd.crudthymeleaf.model.Person;

@Repository
public class PersonRepository {
    private ArrayList<Person> persons = new ArrayList<>();

    public PersonRepository() {
        try {
            File file = ResourceUtils.getFile("classpath:static/persons.json");
            ObjectMapper mapper = new ObjectMapper();
            persons.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {
            }));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Person> getAllPerson() {
        return persons;
    }
}
