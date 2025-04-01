package se.yrgo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Director {
    @Id
    private String dirId;
    private String name;
    @OneToMany
    @JoinColumn(name = "DIRECTOR_FK")
    private List<Movie> movies;

    public Director(String dirId, String name) {
        this.dirId = dirId;
        this.name = name;
        this.movies = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Director [dirId=" + dirId + ", name=" + name + ", movies=" + movies + "]";
    }

    public void addMovieToDirector(Movie movie) {
        this.movies.add(movie);
    }

    public List<Movie> getMoviesByDirector() {
        List<Movie> unmodifiable = Collections.unmodifiableList(this.movies);
        return unmodifiable;

    }

}
