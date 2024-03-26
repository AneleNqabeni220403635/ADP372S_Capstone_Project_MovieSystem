package za.ac.cput.repository;
/*
    Hermanus J Neethling
    220526303
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cinema;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CinemaRepositoryTest {
    private ICinemaRepository cinemaRepository;

    @BeforeEach
    void setUp()
    {
        cinemaRepository = CinemaRepository.getInstance();
    }

    @Test
    void testSaveAndFindById()
    {
        // Given
        Cinema cinema = new Cinema.Builder()
                .cinemaId("Cinema123")
                .numberOfRows(10)
                .seatsPerRow(20)
                .build();

        // When
        cinemaRepository.save(cinema);
        Cinema retrievedCinema = cinemaRepository.findById("Cinema123");

        // Then
        assertNotNull(retrievedCinema);
        assertEquals("Cinema123", retrievedCinema.getCinemaId());
        assertEquals(10, retrievedCinema.getNumberOfRows());
        assertEquals(20, retrievedCinema.getSeatsPerRow());
    }

    @Test
    void testUpdate()
    {
        // Given
        Cinema cinema = new Cinema.Builder()
                .cinemaId("Cinema_XYZ")
                .numberOfRows(8)
                .seatsPerRow(15)
                .build();
        cinemaRepository.save(cinema);

        Cinema updatedCinema = new Cinema.Builder()
                .cinemaId("Cinema_XYZ")
                .numberOfRows(12)  // Update number of rows
                .seatsPerRow(18)   // Update seats per row
                .build();

        // When
        cinemaRepository.update(updatedCinema);

        // Then
        Cinema retrievedCinema = cinemaRepository.findById("Cinema_XYZ");
        assertNotNull(retrievedCinema);
        assertEquals("Cinema_XYZ", retrievedCinema.getCinemaId());
        assertEquals(12, retrievedCinema.getNumberOfRows());
        assertEquals(18, retrievedCinema.getSeatsPerRow());
    }

    @Test
    void testDelete()
    {
        // Given
        Cinema cinema = new Cinema.Builder()
                .cinemaId("Cinema_DEF")
                .numberOfRows(5)
                .seatsPerRow(10)
                .build();
        cinemaRepository.save(cinema);

        // When
        cinemaRepository.delete("Cinema_DEF");

        // Then
        Cinema retrievedCinema = cinemaRepository.findById("Cinema_DEF");
        assertNull(retrievedCinema);
    }

    @Test
    void testFindAll()
    {
        // Given
        cinemaRepository.save(new Cinema.Builder().cinemaId("Cinema 1").numberOfRows(10).seatsPerRow(20).build());
        cinemaRepository.save(new Cinema.Builder().cinemaId("Cinema 2").numberOfRows(20).seatsPerRow(40).build());
        cinemaRepository.save(new Cinema.Builder().cinemaId("Cinema 3").numberOfRows(30).seatsPerRow(60).build());

        // When
        List<Cinema> cinemaList = cinemaRepository.findAll();

        // Then
        assertNotNull(cinemaList);
        assertEquals(3, cinemaList.size());
    }
}
