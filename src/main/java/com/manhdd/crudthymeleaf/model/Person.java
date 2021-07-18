package com.manhdd.crudthymeleaf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
// @Table(name = "")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    // @Column(name = "name")
    private String name;

    // @Column(name = "job")
    private String job;

    // @Column(name = "gender")
    private String gender;

    // @Column(name = "birthday" )
    private String birthday;

}
