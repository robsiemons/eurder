package be.switchfully.eurder.admin;

import be.switchfully.eurder.admin.dto.AdminDto;
import be.switchfully.eurder.admin.dto.NewAdminDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminMapper {
    public List<AdminDto> mapAdminListToAdminDtoList(List<Admin> adminList) {
        return adminList.stream().map(this::mapAdminToAdminDTO).collect(Collectors.toList());
    }

    private AdminDto mapAdminToAdminDTO(Admin admin) {
        return new AdminDto(admin.getAdminId(),
                            admin.getFirstName(),
                            admin.getLastName(),
                            admin.getUserName());
    }

    public Admin convertDtoToAdmin(NewAdminDto adminDto) {
        return new Admin(adminDto.getFirstName(),
                         adminDto.getLastName(),
                         adminDto.getUserName(),
                         adminDto.getPassword());
    }
}
