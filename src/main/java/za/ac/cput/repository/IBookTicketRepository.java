package za.ac.cput.repository;
/* BookTicket.java
BookTicket model class
Author: Asanda Mbangata (222927259)
Date: 21 March 2024
*/

import za.ac.cput.domain.BookTicket;
import java.util.Set;

public interface IBookTicketRepository extends IRepository<BookTicket, String>{
    Set<BookTicket> getAll();
}
