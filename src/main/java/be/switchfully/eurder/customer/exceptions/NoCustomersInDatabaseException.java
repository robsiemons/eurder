package be.switchfully.eurder.customer.exceptions;

public class NoCustomersInDatabaseException extends RuntimeException {
    public NoCustomersInDatabaseException() {
        super("There are currently no customers in the database");
    }
}
