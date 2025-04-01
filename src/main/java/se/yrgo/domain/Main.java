package se.yrgo.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.transaction.Transaction;

public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Director dir1 = new Director("ABC123", "George Lucas" );
        Movie movie1 = new Movie(1, "Star Wars");
        Movie movie2 = new Movie(2, "Indiana Jones");
        dir1.addMovieToDirector(movie1);
        dir1.addMovieToDirector(movie2);

        Director dir2 = new Director("CBA321", "Edgar Wright");
        Movie movie3 = new Movie(3, "Scott pilgrim");
        Movie movie4 = new Movie(4, "baby driver");
        dir2.addMovieToDirector(movie3);
        dir2.addMovieToDirector(movie4);


        List<Movie>movies = dir1.getMoviesByDirector();
        for(Movie i : movies){
            System.out.println(i);
        }
        
        session.save(dir1);
        session.save(movie1);
        session.save(movie2);

        session.save(dir2);
        session.save(movie3);
        session.save(movie4);

    

        tx.commit();
        session.close();

    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}

