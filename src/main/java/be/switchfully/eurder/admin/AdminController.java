package be.switchfully.eurder.admin;

import be.switchfully.eurder.admin.dto.AdminDto;
import be.switchfully.eurder.admin.dto.NewAdminDto;
import be.switchfully.eurder.security.SecurityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    private final AdminService adminService;
    private final SecurityService securityService;

    public AdminController(AdminService adminService, SecurityService securityService) {
        this.adminService = adminService;
        this.securityService = securityService;
    }

    @PostMapping("list")
    public List<AdminDto> getAdminList() {
        return adminService.getAdminList();
    }

    @PostMapping("new")
    public void addAdmin(@RequestBody NewAdminDto adminDto){
        adminService.addAdmin(adminDto);
    }
}
