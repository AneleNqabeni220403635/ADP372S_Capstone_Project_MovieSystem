package za.ac.cput.domain;
/* Main.java
    Main model class
    Author: Anele Nqabeni (220403635)
    Date: 17 March 2024
    */
import za.ac.cput.factory.BookTicketFactory;
import za.ac.cput.factory.MovieFactory;
import za.ac.cput.repository.BookTicketRepository;
import za.ac.cput.repository.IBookTicketRepository;

import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Movie movie = MovieFactory.createMovie("1", "Fast and Furious 8", "Vin Diesel", 2022, "Action", 148);
        printMovie(movie);

        Movie movie1 = MovieFactory.createMovie("2", "Lift", "Kevin Hart", 2023, "Action", 136);
        printMovie(movie1);

        Movie movie2 = MovieFactory.createMovie("3", "John Wick 4", "Keanu Reeves", 2022, "Action", 210);
        printMovie(movie2);

        BookTicket bookTicket1 = BookTicketFactory.createBookTicket("BFW-ZTRYT-213", "John Wick 4", "Daniella Gilbert", LocalDateTime.parse("2024-04-13T18:30"), "B17");
        BookTicket bookTicket2 = BookTicketFactory.createBookTicket("XLT-FLBSW-887", "Lift", "Jonathan Ford", LocalDateTime.parse("2024-04-26T20:30"), "F50");
        BookTicket bookTicket3 = BookTicketFactory.createBookTicket("SGB-MBWPA-652","Fast and Furious 8", "Sydney April", LocalDateTime.parse("2024-04-20T20:00"), "A05");

        IBookTicketRepository bookTicketRepository = BookTicketRepository.getRepository();
        bookTicketRepository.create(bookTicket1);
        bookTicketRepository.create(bookTicket2);
        bookTicketRepository.create(bookTicket3);

        Set<BookTicket> allBookTickets = bookTicketRepository.getAll();
        for (BookTicket bookTicket : allBookTickets) {
            System.out.println(bookTicket);
        }
    }

    private static void printMovie(Movie movie) {
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("Movie object not set");
        }
    }
}