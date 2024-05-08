package za.ac.cput.repository;

/* BookTicket.java
BookTicket model class
Author: Asanda Mbangata (222927259)
Date: 21 March 2024
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.BookTicket;
import java.time.LocalDateTime;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.repository.BookTicketRepository.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookTicketRepositoryTest {
    private IBookTicketRepository bookTicketRepository = getRepository();

    @Test
    @Order(1)
    public void testCreateBookTicket() {
        BookTicket bookTicket = new BookTicket.Builder().setBookTicketId("MGC-YKXWR-650").setMovieId("Avatar").setCustomer("Cole Adams").setDateTime(LocalDateTime.parse("2024-05-04T17:30")).setSeatNumber("A02").build();
        BookTicket createdBookTicket = bookTicketRepository.create(bookTicket);

        assertNotNull(createdBookTicket);
        System.out.println("BookTicket created: " + createdBookTicket.getBookTicketId());
    }

    @Test
    @Order(2)
    public void testReadBookTicket() {
        String bookTicketId = "XLT-FLBSW-887";

        BookTicket readBookTicket = bookTicketRepository.read(bookTicketId);

        assertNotNull(readBookTicket);
        System.out.println("Read: " + readBookTicket.getBookTicketId());
    }
    @Test
    @Order(3)
    public void testUpdateBookTicket() {
        String bookTicketId = "MGC-YKXWR-650";
        BookTicket bookTicket = bookTicketRepository.read(bookTicketId);

        BookTicket updatedBookTicket = new BookTicket.Builder()
                .copy(bookTicket)
                .setCustomer("Jane Carter")
                .build();

        BookTicket updated = bookTicketRepository.update(updatedBookTicket);

        assertNotNull(updated);
        System.out.println("Updated: " + updated.getBookTicketId());
        System.out.println(updated);
    }

    @Test
    @Order(4)
    public void testDeleteBookTicket() {
        String bookTicketId = "MGC-YKXWR-650";
        bookTicketRepository.delete(bookTicketId);

        BookTicket deletedBookTicket = bookTicketRepository.read(bookTicketId);
        assertNull(deletedBookTicket);

        System.out.println("BookTicket deleted");
    }

    @Test
    @Order(5)
    public void testGetAllBookTickets() {
        Set<BookTicket> allBookTickets = bookTicketRepository.getAll();
        for (BookTicket bookTicket : allBookTickets) {
            System.out.println(bookTicket);
        }
    }
}


