package za.ac.cput.repository;
/*Thandiwe Mhlongo
222011777*/
import za.ac.cput.domain.Customer;

import java.util.Set;
public interface ICustomerRepository {
    Customer create(Customer customer);

    Customer read(String customerId);

    Customer update(Customer customer);


    void delete(String customerId);

    Set<Customer> getAll();
}
