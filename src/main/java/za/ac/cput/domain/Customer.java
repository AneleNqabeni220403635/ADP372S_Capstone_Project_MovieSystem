package za.ac.cput.domain;
/*Thandiwe Mhlongo
222011777*/

import java.util.Date;

public class Customer {
    private String customerId;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;

    private Customer(){

    }
    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder {
        // Required parameters
        private String customerId;
        private String name;
        private String lastName;


        private Date dateOfBirth = new Date();
        private String email = "";
        private String phoneNumber = "";


        public Builder(String customerId, String name, String lastName) {
            this.customerId = customerId;
            this.name = name;
            this.lastName = lastName;
        }


        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }


        public Customer build() {
            return new Customer(this);
        }
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
