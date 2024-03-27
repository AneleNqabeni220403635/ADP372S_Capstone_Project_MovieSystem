package za.ac.cput.repository;
/* DirectorRepositoryTest.java
DirectorRespositoryTest model class
Author: Lindiwe Magagula (222037881)
Date: 24 March 2024
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Director;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class DirectorRepositoryTest {
    private IDirectorRepository directorRepository = DirectorRepository.getRepository();
    ;

    @Test
    @Order(1)
    void testCreateDirector() {
        Director director = new Director.Builder()
                .setDirectorId("4")
                .setName("Jane Campion ")
                .setGender("Female")
                .setNationality("American")
                .setMovieDirected("Barbie")
                .build();

        assertNotNull(directorRepository.create(director));
        System.out.println("Director created: Jane Campion");
    }
    @Test
    @Order(2)
    void testReadDirector() {
        Director janeCampionDirector= directorRepository.read("4");
        assertNotNull(janeCampionDirector);
        System.out.println("Read");
    }
    @Test
    @Order(3)
    void testUpdateDirector() {
        Director updatedDirector = new Director.Builder()
                .copy(directorRepository.read("4"))
                .setName("Greta Gerwig ")
                .build();

        assertNotNull(directorRepository.update(updatedDirector));
        System.out.println("Updated");
    }
    @Test
    @Order(4)
    void testDeleteDirector() {
        Director janeCampionDirector = directorRepository.read("4");
        assertNotNull(janeCampionDirector);


        Director updatedDirector = new Director.Builder()
                .copy(janeCampionDirector)
                .setName("Greta Gerwig")
                .build();

        assertNotNull(directorRepository.update(updatedDirector));
        System.out.println("Success: director deleted");
    }
    @Test
    @Order(5)
    void testGetAllDirectors() {

        System.out.println(directorRepository.getAll());

    }
}
