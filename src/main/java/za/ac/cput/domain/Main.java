package za.ac.cput.domain;
/* Main.java
    Main model class
    Author: Anele Nqabeni (220403635), Thandiwe Mhlongo(222011777), Hermanus Neethling (220526303), Lindiwe Magagula (222037881)
    Date: 17 March 2024
    */

import za.ac.cput.factory.*;
import za.ac.cput.repository.BookTicketRepository;
import za.ac.cput.repository.IBookTicketRepository;

import java.time.LocalDateTime;
import java.util.Set;

import za.ac.cput.factory.MovieFactory;
import za.ac.cput.repository.CinemaRepository;
import za.ac.cput.repository.ICinemaRepository;

import java.util.Date;


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
        BookTicket bookTicket3 = BookTicketFactory.createBookTicket("SGB-MBWPA-652", "Fast and Furious 8", "Sydney April", LocalDateTime.parse("2024-04-20T20:00"), "A05");

        IBookTicketRepository bookTicketRepository = BookTicketRepository.getRepository();
        bookTicketRepository.create(bookTicket1);
        bookTicketRepository.create(bookTicket2);
        bookTicketRepository.create(bookTicket3);

        Set<BookTicket> allBookTickets = bookTicketRepository.getAll();
        for (BookTicket bookTicket : allBookTickets) {
            System.out.println(bookTicket);
        }

        Customer customer1 = CustomerFactory.createCustomer("C123", "Thandiwe", "Mhlongo",
                new Date(90, 01, 01), "thandiwemhlogo@gmail.com", "1234567890");

        Customer customer2 = new Customer.Builder("C246", "Lona", "Smith")
                .dateOfBirth(new Date(95, 05, 15))
                .email("lonasmith@gmail.com")
                .phoneNumber("9876543210")
                .build();

        System.out.println("Customer 1:");
        printCustomerDetails(customer1);

        System.out.println("\nCustomer 2:");
        printCustomerDetails(customer2);

        // Cinema
        System.out.println();
        ICinemaRepository cinemaRepository = CinemaRepository.getInstance();
        Cinema cinema1 = new Cinema.Builder()
                .cinemaId("Cinema 1")
                .numberOfRows(10)
                .seatsPerRow(20)
                .build();

        cinemaRepository.save(cinema1);

        Cinema cinema2 = CinemaFactory.createCinema("Cinema 2", 26, 50);
        cinemaRepository.save(cinema2);

        Cinema cinema3 = CinemaFactory.createCinema("Cinema 3", 8, 15);
        cinemaRepository.save(cinema3);

        cinemaRepository.delete(cinema2.getCinemaId());

        for (Cinema cinema : cinemaRepository.findAll())
            System.out.println(cinema);

        //Displaying Director
        System.out.println("\n" + "Director:");

        Director director = DirectorFactory.createDirector("1", "Vin Diesel", "Male", "American", "Witch Hunter");
        printDirector(director);

        Director director1 = DirectorFactory.createDirector("2", "Kevin Hart", "Male", "American", "Man from Toronto");
        printDirector(director1);

        Director director2 = DirectorFactory.createDirector("3", "Keanu Reeves", "Male", "Canadian", "The Matrix");
        printDirector(director2);

        System.out.println("TicketPayment:");
        TicketPayment ticketPayment = TicketPaymentFactory.createTicketPayment("1", "T001", 100.00, "Credit Card",
                LocalDateTime.parse("2024-03-19T00:00:00"));
        printTicketPayment(ticketPayment);

        TicketPayment ticketPayment1 = TicketPaymentFactory.createTicketPayment("2", "T002", 75.50, "Debit Card",
                LocalDateTime.parse("2024-03-20T00:00:00"));
        printTicketPayment(ticketPayment1);

        TicketPayment ticketPayment2 = TicketPaymentFactory.createTicketPayment("3", "T003", 50.00, "Credit Card",
                LocalDateTime.parse("2024-03-21T00:00:00"));
        printTicketPayment(ticketPayment2);
    }


    private static void printMovie(Movie movie) {
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("Movie object not set");
        }
    }

    private static void printCustomerDetails(Customer customer) {
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Name: " + customer.getName() + " " + customer.getLastName());
            System.out.println("Date of Birth: " + customer.getDateOfBirth());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
        } else {
            System.out.println("Customer details not available.");
        }
    }

    private static void printDirector(Director director) {
        if (director != null) {
            System.out.println(director);
        } else {
            System.out.println("Director object not set");
        }
    }

    private static void printTicketPayment(TicketPayment ticketPayment) {
        if (ticketPayment != null) {
            System.out.println(ticketPayment);
        } else {
            System.out.println("TicketPayment object not set");
        }

    }
}



