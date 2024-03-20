package za.ac.cput.repository;
/* Movie.java
IMovieRepository model class
Author: Anele Nqabeni (220403635)
Date: 18 March 2024
*/

import za.ac.cput.domain.Movie;

import java.util.Set;

public interface IMovieRepository extends IRepository<Movie, String> {
    Set<Movie> getAll();
}

