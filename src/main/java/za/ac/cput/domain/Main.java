package za.ac.cput.domain;
/* Main.java
    Main model class
    Author: Anele Nqabeni (220403635), Thandiwe Mhlongo(222011777), Hermanus Neethling (220526303)
    Date: 17 March 2024
    */
import za.ac.cput.factory.CinemaFactory;
import za.ac.cput.factory.CustomerFactory;
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
}

