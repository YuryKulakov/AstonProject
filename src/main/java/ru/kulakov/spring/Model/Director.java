package ru.kulakov.spring.Model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Director {
    int id;
    @NotEmpty(message = "Name should no be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 30 characters")
    String name;
    @Min(value = 0, message = "Age should not be empty")
    int age;

    public Director() {
    }

    public Director(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
