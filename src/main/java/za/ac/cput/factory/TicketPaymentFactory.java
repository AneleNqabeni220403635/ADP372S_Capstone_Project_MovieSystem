package za.ac.cput.factory;
/* TicketPaymentFactory.java
TicketPaymentFactory model class
Author: Khethubonga Ngodi(219294267)
Date: 17 March 2024
*/

import za.ac.cput.domain.TicketPayment;

import java.time.LocalDateTime;

public class TicketPaymentFactory {
    public static TicketPayment createTicketPayment(String paymentId, String bookTicketId, double paymentAmount,
                                                    String paymentMethod, LocalDateTime paymentDate) {
        if (paymentId == null || paymentId.trim().isEmpty()
                || bookTicketId == null || bookTicketId.trim().isEmpty()
                || paymentMethod == null || paymentMethod.trim().isEmpty()
                || paymentDate == null) {
            return null;
        }

        return new TicketPayment.Builder()
                .setPaymentId(paymentId)
                .setBookTicketId(bookTicketId)
                .setPaymentAmount(paymentAmount)
                .setPaymentMethod(paymentMethod)
                .setPaymentDate(paymentDate)
                .build();
    }
}
