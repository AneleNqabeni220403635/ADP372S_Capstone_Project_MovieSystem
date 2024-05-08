package za.ac.cput.repository;
/*Thandiwe Mhlongo
222011777*/
import za.ac.cput.domain.Customer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository {

    private static CustomerRepository repository = null;
    private Map<String, Customer> customerMap;

    private CustomerRepository() {
        customerMap = new HashMap<>();
    }

    public static CustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public Customer read(String customerId) {
        return customerMap.get(customerId);
    }

    @Override
    public Customer update(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public boolean delete(String customerId) {
        customerMap.remove(customerId);
        return true;
    }

    @Override
    public Set<Customer> getAll() {
        return new HashSet<>(customerMap.values());
    }
}
