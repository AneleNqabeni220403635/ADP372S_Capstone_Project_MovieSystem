package za.ac.cput.factory;
/* MovieFactoryTest.java
MovieFactoryTest model class
Author: Anele Nqabeni (220403635)
Date: 19 March 2024
*/
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieFactoryTest {
    Movie movie = MovieFactory.createMovie("1", "Fast and Furious 8", "Vin Diesel", 2022, "Action", 148);
    Movie movie1 = MovieFactory.createMovie("2", "Lift", "Kevin Hart", 2023, "Comedy", 90);
    Movie movie2 = MovieFactory.createMovie("3", "John Wick 4", "Keanu Reeves", 2022, "Action", 120);

    @Test
    @Order(1)
    void testEqualityCreateFastFurious8Movie() {

        assertNotEquals(movie,movie1);

        System.out.println("Equality Movie Test Passed");
    }
    @Test
    @Order(2)
    void testIdentityCreateLiftMovie() {

        assertNotSame(movie,movie2);

        System.out.println("Identity Movie Test Passed");
    }
    @Test
    @Order(3)
    void testNotTheSameCreateJohnWick4Movie() {

        assertNotSame(movie2,movie1);

        System.out.println("Not The Same Movie Test Passed");
    }
}
