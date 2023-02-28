package ru.kulakov.spring.Model;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @OneToOne
    @JoinColumn(name = "director_id",referencedColumnName = "director_id")
    private Director director;
    @Id
    @Column(name = "passport_number",unique = true)
    private int passportNumber;

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Passport() {
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

}
