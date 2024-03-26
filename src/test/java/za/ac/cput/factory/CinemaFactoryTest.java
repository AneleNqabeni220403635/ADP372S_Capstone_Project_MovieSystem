package za.ac.cput.factory;
/*
    Hermanus J Neethling
    220526303
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cinema;
import static org.junit.jupiter.api.Assertions.*;

public class CinemaFactoryTest
{
    @Test
    void testCreateCinema()
    {
        Cinema cinema1 = CinemaFactory.createCinema("Test Cinema 1", 10, 20);
        Cinema cinema2 = CinemaFactory.createCinema("Test Cinema 2", 20, 40);

        assertNotNull(cinema1);
        assertNotNull(cinema2);

        assertEquals("Test Cinema 1", cinema1.getCinemaId());
        assertEquals(10, cinema1.getNumberOfRows());
        assertEquals(20, cinema1.getSeatsPerRow());

        assertEquals("Test Cinema 2", cinema2.getCinemaId());
        assertEquals(20, cinema2.getNumberOfRows());
        assertEquals(40, cinema2.getSeatsPerRow());
    }
}
