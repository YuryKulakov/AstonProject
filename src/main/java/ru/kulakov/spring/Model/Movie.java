package ru.kulakov.spring.Model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int movieId;
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;
    String name;

    public Movie(Director director, int movieId, String name) {
        this.director = director;
        this.movieId = movieId;
        this.name = name;
    }

    public Movie() {

    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
