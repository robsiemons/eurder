package be.switchfully.eurder.customer.dto;

import be.switchfully.eurder.customer.domain.Address;

public class NewCustomerDto {
    private final String firstName, lastName, email, phone, password;
    private final Address address;

    public NewCustomerDto(String firstName, String lastName, String email, String phone, String password, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }
}
