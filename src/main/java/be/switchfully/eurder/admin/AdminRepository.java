package be.switchfully.eurder.admin;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    private final List<Admin> adminList;

    public AdminRepository(List<Admin> adminList) {
        this.adminList = adminList;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void addAdmin(Admin newAdmin){
        adminList.add(newAdmin);
    }

    public Optional<Admin> getAdmin(String adminName) {
        return adminList.stream().filter(admin -> admin.getUserName().matches(adminName)).findFirst();
    }
}
