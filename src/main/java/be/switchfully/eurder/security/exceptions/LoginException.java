package be.switchfully.eurder.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class LoginException extends RuntimeException {
    public LoginException() {
        super("Please check your account name and password and try again.");
    }
}
