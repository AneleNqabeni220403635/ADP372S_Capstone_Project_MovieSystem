package za.ac.cput.repository;
/* MovieRepository.java
MovieRepository model class
Author: Anele Nqabeni (220403635)
Date: 19 March 2024
*/
import za.ac.cput.domain.Movie;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class MovieRepository implements IMovieRepository {

    private static MovieRepository repository = null;
    private Map<String, Movie> movieMap;

    private MovieRepository() {
        movieMap = new HashMap<>();

        movieMap.put("1", new Movie.Builder().setId("1").setTitle("Fast and Furious 8").setDirector("Vin Diesel").setReleaseYear(2022).setGenre("Action").setDuration(148).build());
        movieMap.put("2", new Movie.Builder().setId("2").setTitle("Lift").setDirector("Kevin Hart").setReleaseYear(2023).setGenre("Comedy").setDuration(90).build());
        movieMap.put("3", new Movie.Builder().setId("3").setTitle("John Wick 4").setDirector("Keanu Reeves").setReleaseYear(2022).setGenre("Action").setDuration(120).build());
    }

    public static MovieRepository getRepository() {
        if (repository == null) {
            repository = new MovieRepository();
        }
        return repository;
    }

    @Override
    public Movie create(Movie movie) {
        movieMap.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public Movie read(String id) {
        return movieMap.get(id);
    }

    @Override
    public Movie update(Movie movie) {
        movieMap.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public boolean delete(String id) {
        movieMap.remove(id);
        return true;
    }

    @Override
    public Set<Movie> getAll() {
        return new HashSet<>(movieMap.values());
    }
}
