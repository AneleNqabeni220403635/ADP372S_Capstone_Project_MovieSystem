package za.ac.cput.repository;
/* ITicketPaymentRepository.java
ITicketPaymentRepository model class
Author: Khethubonga Ngodi(219294267)
*/

import za.ac.cput.domain.TicketPayment;

import java.util.Set;

public interface ITicketPaymentRepository extends IRepository< TicketPayment, String> {
    Set<TicketPayment> getAll();

}
