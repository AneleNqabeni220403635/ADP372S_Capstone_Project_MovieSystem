package za.ac.cput.factory;
/* TicketPaymentFactoryTest.java
TicketPaymentFactoryTest model class
Author: Khethubonga Ngodi (219294267)
*/
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import za.ac.cput.domain.TicketPayment;

import java.time.LocalDateTime;

public class TicketPaymentFactoryTest {
    @Test
    void testEqualityCreateFirstTicketPayment() {
        TicketPayment ticketPayment = TicketPaymentFactory.createTicketPayment("1", "T001", 100.00, "Credit Card",
                LocalDateTime.parse("2024-03-19T00:00:00"));

        TicketPayment ticketPayment1 = TicketPaymentFactory.createTicketPayment("2", "T002", 75.50, "Debit Card",
                LocalDateTime.parse("2024-03-20T00:00:00"));

        Assertions.assertNotEquals(ticketPayment, ticketPayment1);
        System.out.println("Equality TicketPayment Test Passed");
    }

    @Test
    void testIdentityCreateSecondTicketPayment() {
        TicketPayment ticketPayment = TicketPaymentFactory.createTicketPayment("1", "T001", 100.00, "Credit Card",
                LocalDateTime.parse("2024-03-19T00:00:00"));

        TicketPayment ticketPayment1 = TicketPaymentFactory.createTicketPayment("1", "T001", 100.00, "Credit Card",
                LocalDateTime.parse("2024-03-19T00:00:00"));

        Assertions.assertEquals(ticketPayment, ticketPayment1);
        System.out.println("Identity TicketPayment Test Passed");
    }

    @Test
    void testNotTheSameCreateThirdTicketPayment() {
        TicketPayment ticketPayment = TicketPaymentFactory.createTicketPayment("1", "T001", 100.00, "Credit Card",
                LocalDateTime.parse("2024-03-19T00:00:00"));

        TicketPayment ticketPayment1 = TicketPaymentFactory.createTicketPayment("2", "T002", 75.50, "Debit Card",
                LocalDateTime.parse("2024-03-20T00:00:00"));

        Assertions.assertNotSame(ticketPayment1, ticketPayment);
        System.out.println("Not The Same TicketPayment Test Passed");
    }
}
