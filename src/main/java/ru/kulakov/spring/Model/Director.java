package ru.kulakov.spring.Model;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "directors")
public class Director {
    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotEmpty(message = "Name should no be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 30 characters")
    @Column(name = "name")
    String name;
    @Min(value = 0, message = "Age should not be empty")
    @Column(name = "age")
    int age;
    @OneToMany(mappedBy = "director")
    private List<Movie> movies;
    @OneToOne(mappedBy = "director")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Passport passport;

    public Director() {
    }

    public Director(int id, String name, int age, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.movies = movies;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setDirector(this);
    }


}
