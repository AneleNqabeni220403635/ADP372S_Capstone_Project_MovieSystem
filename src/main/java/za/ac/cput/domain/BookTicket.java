package za.ac.cput.domain;

/* BookTicket.java
BookTicket model class
Author: Asanda Mbangata (222927259)
Date: 20 March 2024
*/

import java.util.Objects;
import java.time.LocalDateTime;
public class BookTicket {
    private String bookTicketId;
    private String movie;
    private String customer;
    private LocalDateTime dateTime;
    private String seatNumber;

    public BookTicket() {}

    private BookTicket(Builder builder) {
        this.bookTicketId = builder.bookTicketId;
        this.movie = builder.movie;
        this.customer = builder.customer;
        this.dateTime = builder.dateTime;
        this.seatNumber = builder.seatNumber;
    }

    public String getBookTicketId() {
        return bookTicketId;
    }

    public String getMovie() {
        return movie;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookTicket)) return false;
        BookTicket that = (BookTicket) o;
        return Objects.equals(getBookTicketId(), that.getBookTicketId()) &&
                Objects.equals(getMovie(), that.getMovie()) &&
                Objects.equals(getCustomer(), that.getCustomer()) &&
                Objects.equals(getDateTime(), that.getDateTime()) &&
                Objects.equals(getSeatNumber(), that.getSeatNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookTicketId(), getMovie(), getCustomer(), getDateTime(), getSeatNumber());
    }

    @Override
    public String toString() {
        return "BookTicket{" +
                "bookTicketId='" + bookTicketId + '\'' +
                ", movie='" + movie + '\'' +
                ", customer='" + customer + '\'' +
                ", dateTime=" + dateTime +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String bookTicketId;
        private String movie;
        private String customer;
        private LocalDateTime dateTime;
        private String seatNumber;

        public Builder setBookTicketId(String bookTicketId) {
            this.bookTicketId = bookTicketId;
            return this;
        }

        public Builder setMovie(String movie) {
            this.movie = movie;
            return this;
        }

        public Builder setCustomer(String customer) {
            this.customer = customer;
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder copy(BookTicket b) {
            if (b != null) {
                this.bookTicketId = b.bookTicketId;
                this.movie = b.movie;
                this.customer = b.customer;
                this.dateTime = b.dateTime;
                this.seatNumber = b.seatNumber;
            }
            return this;
        }

        public BookTicket build() {
            return new BookTicket(this);
        }
    }
}