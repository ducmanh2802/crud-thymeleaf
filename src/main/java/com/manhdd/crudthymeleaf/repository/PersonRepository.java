package com.manhdd.crudthymeleaf.repository;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.manhdd.crudthymeleaf.model.Person;

@Repository
public class PersonRepository extends Dao {
    private final ArrayList<Person> persons = new ArrayList<>();

    public PersonRepository() {
        try {
            final File file = ResourceUtils.getFile("classpath:static/persons.json");
            final ObjectMapper mapper = new ObjectMapper();
            persons.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {
            }));

        } catch (final IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public Optional<Person> get(final int id) {
        return persons.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void add(Person person) {
        long id;
        if (persons.isEmpty()) {
            id = 1;
        } else {
            final Person lastPerson = persons.get(persons.size() - 1);
            id = (lastPerson.getId() + 1);
        }
        person.setId(id);
        persons.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(final Object t) {

    }
}
