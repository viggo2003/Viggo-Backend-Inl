package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    private String name;
 


  
    public Movie(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
       
    }


    public String toString() {
        return "name:" + name;
    }


    public int getMovieId() {
        return movieId;
    }


    public String getName() {
        return name;
    }


   


}
