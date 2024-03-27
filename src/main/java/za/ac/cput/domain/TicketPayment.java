package za.ac.cput.domain;
/* TicketPayment.java
TicketPayment model class
Author: Khethubonga Ngodi(219294267)
Date: 23 March 2024
*/
import java.time.LocalDateTime;


public class TicketPayment {
    private String paymentId;
    private String bookTicketId;
    private double paymentAmount;
    private String paymentMethod;
    private LocalDateTime paymentDate;

    private TicketPayment() {}

    private TicketPayment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.bookTicketId = builder.bookTicketId;
        this.paymentAmount = builder.paymentAmount;
        this.paymentMethod = builder.paymentMethod;
        this.paymentDate = builder.paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getBookTicketId() {
        return bookTicketId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPayment that = (TicketPayment) o;
        return Double.compare(that.paymentAmount, paymentAmount) == 0 &&
                paymentId.equals(that.paymentId) &&
                bookTicketId.equals(that.bookTicketId) &&
                paymentMethod.equals(that.paymentMethod) &&
                paymentDate.equals(that.paymentDate);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(paymentId, bookTicketId, paymentAmount, paymentMethod, paymentDate);
    }

    @Override
    public String toString() {
        return "TicketPayment{" +
                "paymentId='" + paymentId + '\'' +
                ", bookTicketId='" + bookTicketId + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }

    public static class Builder {
        private String paymentId;
        private String bookTicketId;
        private double paymentAmount;
        private String paymentMethod;
        private LocalDateTime paymentDate;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setBookTicketId(String bookTicketId) {
            this.bookTicketId = bookTicketId;
            return this;
        }

        public Builder setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public TicketPayment.Builder copy(TicketPayment e) {
            this.paymentId = e.paymentId;
            this.bookTicketId = e.bookTicketId;
            this.paymentAmount = e.paymentAmount;
            this.paymentMethod = e.paymentMethod;
            this.paymentDate = e.paymentDate;
            return this;
        }

        public TicketPayment build() {
            return new TicketPayment(this);
        }
    }
}
