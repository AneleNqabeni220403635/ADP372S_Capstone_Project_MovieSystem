package za.ac.cput.repository;
/* ITicketPaymentRepository.java
TicketPaymentRepository model class
Author: Khethubonga Ngodi(219294267)

*/
import za.ac.cput.domain.TicketPayment;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class TicketPaymentRepository implements ITicketPaymentRepository {
    private Map<String, TicketPayment> ticketPaymentMap;

    private TicketPaymentRepository() {
        ticketPaymentMap = new HashMap<>();
        initializeData();
    }

    private void initializeData() {
        TicketPayment payment1 = new TicketPayment.Builder()
                .setPaymentId("1")
                .setBookTicketId("T001")
                .setPaymentAmount(100.00)
                .setPaymentMethod("Credit Card")
                .setPaymentDate(LocalDateTime.parse("2024-03-19T00:00:00"))
                .build();
        ticketPaymentMap.put(payment1.getPaymentId(), payment1);

        TicketPayment payment2 = new TicketPayment.Builder()
                .setPaymentId("2")
                .setBookTicketId("T002")
                .setPaymentAmount(75.50)
                .setPaymentMethod("Debit Card")
                .setPaymentDate(LocalDateTime.parse("2024-03-20T00:00:00"))
                .build();
        ticketPaymentMap.put(payment2.getPaymentId(), payment2);
    }

    private static class SingletonHelper {
        private static final TicketPaymentRepository INSTANCE = new TicketPaymentRepository();
    }

    public static TicketPaymentRepository getRepository() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public TicketPayment create(TicketPayment ticketPayment) {
        ticketPaymentMap.put(ticketPayment.getPaymentId(), ticketPayment);
        return ticketPayment;
    }

    @Override
    public TicketPayment read(String paymentId) {
        return ticketPaymentMap.get(paymentId);
    }

    @Override
    public TicketPayment update(TicketPayment ticketPayment) {
        if (ticketPaymentMap.containsKey(ticketPayment.getPaymentId())) {
            ticketPaymentMap.put(ticketPayment.getPaymentId(), ticketPayment);
            return ticketPayment;
        } else {
            throw new IllegalArgumentException("Invalid payment ID: " + ticketPayment.getPaymentId());
        }
    }

    @Override
    public boolean delete(String id) {
        ticketPaymentMap.remove(id);
        return true;
    }

    @Override
    public Set<TicketPayment> getAll() {
        return new HashSet<>(ticketPaymentMap.values());
    }

}
