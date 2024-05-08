package za.ac.cput.repository;

/* BookTicket.java
BookTicket model class
Author: Asanda Mbangata (222927259)
Date: 21 March 2024
*/

import za.ac.cput.domain.BookTicket;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BooleanSupplier;

public class BookTicketRepository implements IBookTicketRepository {
    private static BookTicketRepository repository = null;
    private Set<BookTicket> bookTickets;

    private BookTicketRepository() {
        bookTickets = new HashSet<>();

        bookTickets.add(new BookTicket.Builder().setBookTicketId("BFW-ZTRYT-213").setMovieId("John Wick 4").setCustomer("Daniella Gilbert").setDateTime(LocalDateTime.parse("2024-04-13T18:30")).setSeatNumber("B17").build());
        bookTickets.add(new BookTicket.Builder().setBookTicketId("SGB-MBWPA-652").setMovieId("Fast and Furious 8").setCustomer("Sydney April").setDateTime(LocalDateTime.parse("2024-04-20T20:00")).setSeatNumber("A05").build());
        bookTickets.add(new BookTicket.Builder().setBookTicketId("XLT-FLBSW-887").setMovieId("Lift").setCustomer("Jonathan Ford").setDateTime(LocalDateTime.parse("2024-04-26T20:30")).setSeatNumber("F50").build());
    }

    public static BookTicketRepository getRepository() {
        if (repository == null) {
            repository = new BookTicketRepository();
        }
        return repository;
    }

    @Override
    public BookTicket create(BookTicket bookTicket) {
        bookTickets.add(bookTicket);
        return bookTicket;
    }

    @Override
    public BookTicket read(String bookTicketId) {
        for (BookTicket bookTicket : bookTickets) {
            if (bookTicket.getBookTicketId().equals(bookTicketId)) {
                return bookTicket;
            }
        }
        return null;
    }
    @Override
    public BookTicket update(BookTicket bookTicket) {
        return bookTicket;
    }
    @Override
    public boolean delete(String bookTicketId) {
        BookTicket bookTicket = read(bookTicketId);
        if (bookTicket != null) {
            bookTickets.remove(bookTicket);
        }
        return true;
    }
    @Override
    public Set<BookTicket> getAll() {
        return new HashSet<>(bookTickets);
    }
}