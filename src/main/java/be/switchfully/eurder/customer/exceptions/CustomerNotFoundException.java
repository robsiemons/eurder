package be.switchfully.eurder.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String id) {
        super("Customer with id: " + id + " not found");
    }
}
