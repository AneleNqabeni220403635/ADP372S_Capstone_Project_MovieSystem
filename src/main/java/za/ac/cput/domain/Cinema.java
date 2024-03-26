package za.ac.cput.domain;
/*
    Hermanus J Neethling
    220526303
*/
public class Cinema {
    private String cinemaId;
    private int numberOfRows;
    private int seatsPerRow;

    // Private constructor to prevent direct instantiation
    private Cinema(Builder builder)
    {
        this.cinemaId = builder.cinemaId;
        this.numberOfRows = builder.numberOfRows;
        this.seatsPerRow = builder.seatsPerRow;
    }

    // Getters for the private variables
    public String getCinemaId()
    {
        return cinemaId;
    }

    public int getNumberOfRows()
    {
        return numberOfRows;
    }

    public int getSeatsPerRow()
    {
        return seatsPerRow;
    }

    @Override
    public String toString() {
        return "Cinema " + cinemaId + " has " + numberOfRows + " rows and " + seatsPerRow + " seats per row.";
    }

    // Builder class for Cinema
    public static class Builder
    {
        private String cinemaId;
        private int numberOfRows;
        private int seatsPerRow;

        // Setter methods for Builder
        public Builder cinemaId(String cinemaId)
        {
            this.cinemaId = cinemaId;
            return this;
        }

        public Builder numberOfRows(int numberOfRows)
        {
            this.numberOfRows = numberOfRows;
            return this;
        }

        public Builder seatsPerRow(int seatsPerRow)
        {
            this.seatsPerRow = seatsPerRow;
            return this;
        }

        // Build method to create Cinema instance
        public Cinema build()
        {
            return new Cinema(this);
        }
    }
}
