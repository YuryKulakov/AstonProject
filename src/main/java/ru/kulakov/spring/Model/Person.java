package ru.kulakov.spring.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotEmpty(message = "Name should no be empty")
    @Column(name = "name")
    @Size(min = 2, max = 30, message = "Name should be between 2 30 characters")
    String name;
    @Column(name = "age")
    @Min(value = 0, message = "Age should not be empty")
    Integer age;
    @Email
    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty")
    String email;

    public Person() {
    }

    public Person(String name, Integer age,String email) {
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
