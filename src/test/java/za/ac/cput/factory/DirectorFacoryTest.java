package za.ac.cput.factory;
/* DirectorFactoryTest.java
DirectorFactoryTest model class
Author: Lindiwe Magagula (222037881)
Date: 24 March 2024
 */

import org.junit.jupiter.api.Order;
import za.ac.cput.domain.Director;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DirectorFacoryTest {
    Director director = DirectorFactory.createDirector("1","Vin Diesel","Male","American","Witch Hunter");
    Director director1 = DirectorFactory.createDirector("2","Kevin Hart","Male","American","Man from Toronto");
    Director director2 = DirectorFactory.createDirector("3","Keanu Reeves","Male","Canadian","The Matrix");

    @Test
    @Order(1)
    void testEqualityCreateVinDieselDirector(){
        assertNotEquals(director, director1);
        System.out.println("Test Passed");
    }
    @Test
    @Order(2)
    void testIdentityCreateKevinHartDirector(){
        assertNotSame(director, director2);
        System.out.println("Test Passed");
    }
    @Test
    @Order(3)
    void testNotTheSameCreateKeanuReevesDirector(){
        assertNotEquals(director2, director1);
        System.out.println("Test Passed");
    }

}
