package be.switchfully.eurder.customer.dto;

import be.switchfully.eurder.customer.domain.Address;

public class CustomerDto {
    private final String customerId;
    private final String firstName, lastName, email, phone;
    private final Address address;

    public CustomerDto(String customerId, String firstName, String lastName, String email, String phone, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerId() {
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

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }


}
