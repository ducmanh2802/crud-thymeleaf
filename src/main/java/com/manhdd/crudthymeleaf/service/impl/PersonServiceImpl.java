package com.manhdd.crudthymeleaf.service.impl;

import com.manhdd.crudthymeleaf.model.Person;
import com.manhdd.crudthymeleaf.repository.PersonRepository;
import com.manhdd.crudthymeleaf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        if (person != null) {
            return personRepository.save(person);
        }
        return null;
    }

    @Override
    public Person updatePerson(long id, Person person) {
        Person updatePerson = personRepository.getById(id);
        if (updatePerson != null) {
            updatePerson.setName(person.getName());
            updatePerson.setJob(person.getJob());
            updatePerson.setGender(person.getGender());
            updatePerson.setBirthDay(person.getBirthDay());
            personRepository.save(updatePerson);
        }
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(long id) {
        return personRepository.getById(id);
    }

    @Override
    public boolean deletePerson(long id) {
        if (id >= 1) {
            Person deletePerson = personRepository.getById(id);
            if (deletePerson != null) {
                personRepository.delete(deletePerson);
                return true;
            }
        }
        return false;
    }
}
