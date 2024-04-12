package be.switchfully.eurder.customer.domain;

import be.switchfully.eurder.security.Feature;
import be.switchfully.eurder.security.Role;

import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;
    private final String password;
    private final Role role;

    public Customer(String firstName, String lastName, String email, Address address, String phoneNumber, String password) {
        this.password = password;
        this.customerId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = Role.CUSTOMER;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public boolean canHaveAccessTo(Feature feature) {
        return role.containsFeature(feature);
    }

    public boolean doesPasswordMatch(String password) {
        return this.password.equals(password);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "Id= " + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                address +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
