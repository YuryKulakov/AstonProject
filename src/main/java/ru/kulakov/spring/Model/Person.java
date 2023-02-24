package ru.kulakov.spring.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Person {
    Integer id;
    @NotEmpty(message = "Name should no be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 30 characters")
    String name;
    @Min(value = 0, message = "Age should not be empty")
    Integer age;
    @NotEmpty(message = "Email should no be empty")
    @Email(message = "Email should be valid")
    String email;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
