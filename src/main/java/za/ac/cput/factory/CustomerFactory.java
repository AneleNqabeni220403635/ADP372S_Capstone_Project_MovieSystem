package za.ac.cput.factory;
/*Thandiwe Mhlongo
222011777*/

import za.ac.cput.domain.Customer;
import java.util.Date;
public class CustomerFactory {
    public static Customer createCustomer(String customerId, String name, String lastName, Date dateOfBirth, String email, String phoneNumber) {
        if (customerId == null || customerId.trim().isEmpty() || name == null || name.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty() || dateOfBirth == null || email == null || email.trim().isEmpty() ||
                phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return null;
        }

        return new Customer.Builder(customerId, name, lastName)
                .dateOfBirth(dateOfBirth)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
