package be.switchfully.eurder.admin.exception;

public class NotAnAdminException extends RuntimeException{
    public NotAnAdminException() {
        super("You are not an admin and have no power (or access) here" );
    }
}
