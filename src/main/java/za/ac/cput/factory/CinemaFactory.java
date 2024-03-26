package za.ac.cput.factory;
/*
    Hermanus J Neethling
    220526303
*/
import za.ac.cput.domain.Cinema;

public class CinemaFactory {
    public static Cinema createCinema(String cinemaId, int numberOfRows, int seatsPerRow) {
        return new Cinema.Builder()
                .cinemaId(cinemaId)
                .numberOfRows(numberOfRows)
                .seatsPerRow(seatsPerRow)
                .build();
    }
}
