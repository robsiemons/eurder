package be.switchfully.eurder.admin.dto;

public class AdminDto {
    private final String adminId, firstName,lastName, userName;

    public AdminDto(String adminId, String firstName, String lastName, String userName) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }
}
