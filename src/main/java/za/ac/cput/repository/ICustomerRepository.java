package za.ac.cput.repository;
/*Thandiwe Mhlongo
222011777*/
import za.ac.cput.domain.Customer;

import java.util.Set;
public interface ICustomerRepository extends IRepository<Customer, String> {
    Set<Customer> getAll();
}
