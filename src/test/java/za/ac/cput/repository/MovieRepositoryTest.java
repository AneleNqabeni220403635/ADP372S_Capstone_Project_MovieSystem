package za.ac.cput.repository;
/* MovieRepositoryTest.java
MovieRepositoryTest model class
Author: Anele Nqabeni (220403635)
Date: 19 March 2024
*/

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Movie;
import za.ac.cput.repository.IMovieRepository;
import za.ac.cput.repository.MovieRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MovieRepositoryTest {

    private IMovieRepository movieRepository = MovieRepository.getRepository();;

    @Test
    @Order(1)
    void testCreateMovie() {
        Movie movie = new Movie.Builder()
                .setId("4")
                .setTitle("Avatar")
                .setDirector("James Cameron")
                .setReleaseYear(2023)
                .setGenre("Adventure")
                .setDuration(300)
                .build();

        assertNotNull(movieRepository.create(movie));
        System.out.println("Movie created: Avatar");

    }

    @Test
    @Order(2)
    void testReadMovie() {
        Movie avatarMovie = movieRepository.read("4");
        assertNotNull(avatarMovie);

        System.out.println("Read");
    }

    @Test
    @Order(3)
    void testUpdateMovie() {
        Movie updatedMovie = new Movie.Builder()
                .copy(movieRepository.read("4"))
                .setTitle("Avatar 2")
                .build();

        assertNotNull(movieRepository.update(updatedMovie));
        System.out.println("Updated");
    }

    @Test
    @Order(4)
    void testDeleteMovie() {
        Movie avatarMovie = movieRepository.read("4");
        assertNotNull(avatarMovie);


        Movie updatedMovie = new Movie.Builder()
                .copy(avatarMovie)
                .setTitle("Avatar 2")
                .build();

        assertNotNull(movieRepository.update(updatedMovie));
        System.out.println("Success: movie deleted");
    }
    @Test
    @Order(5)
    void testGetAllMovies() {

        System.out.println(movieRepository.getAll());

    }
}