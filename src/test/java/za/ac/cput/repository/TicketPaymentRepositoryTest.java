package za.ac.cput.repository;
/* TicketPaymentRepositoryTest.java
TicketPaymentRepositoryTest model class
Author: Khethubonga Ngodi (219294267)
*/
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import za.ac.cput.domain.TicketPayment;

import java.time.LocalDateTime;
import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TicketPaymentRepositoryTest {
    private ITicketPaymentRepository ticketPaymentRepository;

    @BeforeEach
    void setUp() {
        // Perform setup tasks if needed
        ticketPaymentRepository = TicketPaymentRepository.getRepository();
    }

    @AfterEach
    void tearDown() {
        // Perform cleanup tasks if needed
    }

    @BeforeAll
    static void setUpAll() {
        // Perform one-time setup tasks if needed
    }

    @AfterAll
    static void tearDownAll() {
        // Perform one-time cleanup tasks if needed
    }

    @Test
    @Order(1)
    void testCreateTicketPayment() {
        TicketPayment ticketPayment = new TicketPayment.Builder()
                .setPaymentId("5")
                .setBookTicketId("T001")
                .setPaymentAmount(100.00)
                .setPaymentMethod("Credit Card")
                .setPaymentDate(LocalDateTime.parse("2024-03-19T00:00:00"))
                .build();

        assertNotNull(ticketPaymentRepository.create(ticketPayment));
        System.out.println("Ticket Payment created with ID: 4");
    }

    @Test
    @Order(2)
    void testReadTicketPayment() {
        TicketPayment ticketPayment = ticketPaymentRepository.read("5");
        assertNotNull(ticketPayment);
        System.out.println("Read Ticket Payment: " + ticketPayment);
    }

    @Test
    @Order(3)
    void testUpdateTicketPayment() {
        TicketPayment updatedTicketPayment = new TicketPayment.Builder()
                .copy(ticketPaymentRepository.read("5"))
                .setBookTicketId("T002")
                .build();

        assertNotNull(ticketPaymentRepository.update(updatedTicketPayment));
        System.out.println("Updated Ticket Payment: " + updatedTicketPayment);
    }

    @Test
    @Order(4)
    void testDeleteTicketPayment() {
        TicketPayment ticketPayment = ticketPaymentRepository.read("5");
        assertNotNull(ticketPayment);

        assertTrue(ticketPaymentRepository.delete("5"));
        System.out.println("Deleted Ticket Payment with ID: 5");
    }

    @Test
    @Order(5)
    void testGetAllTicketPayments() {
        Set<TicketPayment> ticketPayments = ticketPaymentRepository.getAll();
        System.out.println("All Ticket Payments: " + ticketPayments);
    }
    }