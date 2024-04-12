package be.switchfully.eurder.security;

public class UserNamePassword {

    private final String userName, password;

    public UserNamePassword(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
