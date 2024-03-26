package za.ac.cput.repository;
/*Thandiwe Mhlongo
222011777*/

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import za.ac.cput.domain.Customer;

import java.util.Date;
public class CustomerRepositoryTest {
    private CustomerRepository repository;

    @Before
    public void setUp() {
        repository = CustomerRepository.getRepository();
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer.Builder("C123", "Thandiwe", "Mhlongo")
                .dateOfBirth(new Date(90, 01, 01))
                .email("thandiwemhlongo@gmail.com")
                .phoneNumber("1234567890")
                .build();

        Customer createdCustomer = repository.create(customer);

        assertNotNull(createdCustomer);
        assertEquals(customer, createdCustomer);
    }

    @Test
    public void testReadCustomer() {
        Customer customer = new Customer.Builder("C123", "Thandiwe", "Mhlongo")
                .dateOfBirth(new Date(95, 05, 15))
                .email("thandiwemhlongo@gmail.com")
                .phoneNumber("1234567890")
                .build();

        repository.create(customer);

        Customer retrievedCustomer = repository.read("C123");

        assertNotNull(retrievedCustomer);
        assertEquals(customer, retrievedCustomer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer.Builder("C123", "Thandiwe", "Mhlongo")
                .dateOfBirth(new Date())
                .email("thandiwemhlongo@gmail.com.com")
                .phoneNumber("1234567890")
                .build();

        repository.create(customer);

        Customer updatedCustomer = new Customer.Builder("C123", "Thandiwe", "Mhlongo")
                .dateOfBirth(new Date(90, 01, 01))
                .email("updated@example.com")
                .phoneNumber("0987654321")
                .build();

        repository.update(updatedCustomer);

        Customer retrievedCustomer = repository.read("C123");

        assertNotNull(retrievedCustomer);
        assertEquals(updatedCustomer, retrievedCustomer);
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer.Builder("C123", "Thandiwe", "Mhlongo")
                .dateOfBirth(new Date(90, 01, 01))
                .email("thandiwemhlongo@gmail.com")
                .phoneNumber("1234567890")
                .build();

        repository.create(customer);

        repository.delete("C123");

        assertNull(repository.read("C123"));
    }

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer.Builder("C123", "Thandiwe", "Mhlongo")
                .dateOfBirth(new Date(90, 01, 01))
                .email("thandiwemhlongo@gmail.com")
                .phoneNumber("1234567890")
                .build();

        Customer customer2 = new Customer.Builder("C246", "Lona", "Smith")
                .dateOfBirth(new Date(95, 05, 15))
                .email("lonasmith@gmail.com")
                .phoneNumber("9876543210")
                .build();

        repository.create(customer1);
        repository.create(customer2);

        assertEquals(2, repository.getAll().size());
    }
}
