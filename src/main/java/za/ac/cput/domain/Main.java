package za.ac.cput.domain;
/* Main.java
    Main model class
    Author: Anele Nqabeni (220403635)
    Date: 17 March 2024
    */
import za.ac.cput.factory.MovieFactory;

public class Main {
    public static void main(String[] args) {
        Movie movie = MovieFactory.createMovie("1", "Fast and Furious 8", "Vin Diesel", 2022, "Action", 148);
        printMovie(movie);

        Movie movie1 = MovieFactory.createMovie("2", "Lift", "Kevin Hart", 2023, "Action", 136);
        printMovie(movie1);

        Movie movie2 = MovieFactory.createMovie("3", "John Wick 4", "Keanu Reeves", 2022, "Action", 210);
        printMovie(movie2);
    }

    private static void printMovie(Movie movie) {
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("Movie object not set");
        }
    }
}

