package za.ac.cput.factory;

/* BookTicketFactory.java
BookTicketFactory model class
Author: Asanda Mbangata (222927259)
Date: 20 March 2024
*/

import za.ac.cput.domain.BookTicket;
import java.time.LocalDateTime;
import java.util.Date;

public class BookTicketFactory {
    public static BookTicket createBookTicket(String bookTicketId, String movieId, String customer, LocalDateTime dateTime, String seatNumber) {
        if (isNullOrEmpty(movieId) || isNullOrEmpty(customer) || dateTime == null || isNullOrEmpty(seatNumber)) {
            return null;
        }

        return new BookTicket.Builder()
                .setBookTicketId(bookTicketId)
                .setMovieId(movieId)
                .setCustomer(customer)
                .setDateTime(dateTime)
                .setSeatNumber(seatNumber)
                .build();
    }
    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}