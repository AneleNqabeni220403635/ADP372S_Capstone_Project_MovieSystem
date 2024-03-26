package za.ac.cput.factory;
/*Thandiwe Mhlongo
222011777*/

import static org.junit.Assert.*;
import org.junit.Test;
import za.ac.cput.domain.Customer;

import java.util.Date;
public class CustomerFactoryTest {
    @Test
    public void testCreateCustomer_ValidInput() {
        String customerId = "C123";
        String name = "Thandiwe";
        String lastName = "Mhlongo";
        Date dateOfBirth = new Date(90, 01, 01);
        String email = "thandiwemhlongo@gmail.com";
        String phoneNumber = "123456789";

        Customer customer = CustomerFactory.createCustomer(customerId, name, lastName, dateOfBirth, email, phoneNumber);

        assertNotNull(customer);
        assertEquals(customerId, customer.getCustomerId());
        assertEquals(name, customer.getName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(dateOfBirth, customer.getDateOfBirth());
        assertEquals(email, customer.getEmail());
        assertEquals(phoneNumber, customer.getPhoneNumber());
    }
    @Test
    public void testCreateCustomer_NullInput() {
        Customer customer = CustomerFactory.createCustomer(null, null, null, null, null, null);

        assertNull(customer);
    }

    @Test
    public void testCreateCustomer_EmptyInput() {
        Customer customer = CustomerFactory.createCustomer("", "", "", null, "", "");
        assertNull(customer);
    }
}
