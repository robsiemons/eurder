package be.switchfully.eurder.admin.exception;

public class NoAdminsInDatabaseException extends RuntimeException {

    public NoAdminsInDatabaseException() {
        super("No admins are found");
    }
}
