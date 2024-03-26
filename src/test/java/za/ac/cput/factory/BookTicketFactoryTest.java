package za.ac.cput.factory;

/* BookTicket.java
BookTicket model class
Author: Asanda Mbangata (222927259)
Date: 21 March 2024
*/
import org.junit.jupiter.api.*;
import za.ac.cput.domain.BookTicket;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookTicketFactoryTest {

    BookTicket bookTicket1 = BookTicketFactory.createBookTicket("BFW-ZTRYT-213", "John Wick 4", "Daniella Gilbert", LocalDateTime.parse("2024-04-13T18:30"), "B17");
    BookTicket bookTicket2 = BookTicketFactory.createBookTicket("SGB-MBWPA-652","Fast and Furious 8", "Sydney April", LocalDateTime.parse("2024-04-20T20:00"), "A05");
    BookTicket bookTicket3 = BookTicketFactory.createBookTicket("XLT-FLBSW-887", "Lift", "Jonathan Ford", LocalDateTime.parse("2024-04-26T20:30"), "F50");


    @Test
    @Order(1)
    public void testEqualityCreateBookTicket() {

        assertNotEquals(bookTicket1, bookTicket3);
        System.out.println("Equality BookTicket Test Passed");
    }

    @Test
    @Order(2)
    public void testIdentityCreateBookTicket() {

        assertNotSame(bookTicket1, bookTicket2);
        System.out.println("Identity BookTicket Test Passed");
    }

    @Test
    @Order(3)
    public void testNotTheSameCreateBookTicket() {

        assertNotSame(bookTicket1, bookTicket2);
        System.out.println("Not The Same BookTicket Test Passed");
    }

}