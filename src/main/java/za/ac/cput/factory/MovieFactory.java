package za.ac.cput.factory;
/* MovieFactory.java
    MovieFactory model class
    Author: Anele Nqabeni (220403635)
    Date: 17 March 2024
    */
import za.ac.cput.domain.Movie;

public class MovieFactory {

    public static Movie createMovie(String id, String title, String director, int releaseYear, String genre, int duration) {
        if (id == null || id.trim().isEmpty() || title == null || title.trim().isEmpty() ||
                director == null || director.trim().isEmpty() || genre == null || genre.trim().isEmpty() ||
                releaseYear < 1888 || duration <= 0) {
            return null;
        }

        return new Movie.Builder()
                .setId(id)
                .setTitle(title)
                .setDirector(director)
                .setReleaseYear(releaseYear)
                .setGenre(genre)
                .setDuration(duration)
                .build();
    }
}
