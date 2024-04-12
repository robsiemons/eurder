package be.switchfully.eurder.admin;

import be.switchfully.eurder.admin.dto.AdminDto;
import be.switchfully.eurder.admin.dto.NewAdminDto;
import be.switchfully.eurder.admin.exception.NoAdminsInDatabaseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }


    public List<AdminDto> getAdminList() {
        List<Admin> adminList = adminRepository.getAdminList();
        if(adminList.isEmpty()){
            throw new NoAdminsInDatabaseException();
        }
        return adminMapper.mapAdminListToAdminDtoList(adminList);
    }

    public void addAdmin(NewAdminDto adminDto) {
        adminRepository.addAdmin(
                adminMapper.convertDtoToAdmin(adminDto)
        );
    }
}
