package com.manhdd.crudthymeleaf.service;

import com.manhdd.crudthymeleaf.model.Person;

import java.util.List;

public interface PersonService {
    //Hàm thêm person
    public Person addPerson(Person person);

    //Hàm chỉnh sửa person
    public Person updatePerson(long id, Person person);

    //Hàm lấy ra danh sách person
    public List<Person> getAllPerson();

    //Hàm lấy ra 1 person
    public Person getPersonById(long id);

    //Hàm xóa
    public  boolean deletePerson(long id);
}
