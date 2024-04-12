package be.switchfully.eurder.security;

import be.switchfully.eurder.admin.Admin;
import be.switchfully.eurder.admin.AdminRepository;
import be.switchfully.eurder.admin.exception.NotAnAdminException;
import be.switchfully.eurder.customer.CustomerRepository;
import be.switchfully.eurder.customer.domain.Customer;
import be.switchfully.eurder.customer.exceptions.CustomerNotFoundException;
import be.switchfully.eurder.security.exceptions.LoginException;
import be.switchfully.eurder.security.exceptions.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Base64;

import static java.lang.String.format;

@Component
public class SecurityService {
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    public SecurityService(CustomerRepository customerRepository, AdminRepository adminRepository) {
        this.customerRepository = customerRepository;
        this.adminRepository = adminRepository;
    }

    public void validateAdminAuthorization(String authorization, Feature feature) {
        UserNamePassword userNamePassword = getUserNamePassword(authorization);
        Admin admin = adminRepository.getAdmin(userNamePassword.getUserName())
                                     .orElseThrow(NotAnAdminException::new);

        if (admin == null) {
            logger.error(format("Unknown adminUser %s", userNamePassword.getUserName()));
            throw new UnauthorizedException();
        }
        //Admin admin = optionalAdmin.get();
        if (!admin.doesPasswordMatch(userNamePassword.getPassword())) {
            logger.error(format("Password does not match for user %s", userNamePassword.getUserName()));
            throw new LoginException();
        }
        if (!admin.canHaveAccessTo(feature)) {
            logger.error(format("User %s does not have access to %s", userNamePassword.getUserName(), feature));
            throw new UnauthorizedException();
        }

    }

    public void validateCustomerAuthorization(String auth, Feature feature) {
        UserNamePassword userNamePassword = getUserNamePassword(auth);
        Customer customer = customerRepository.getSpecificCustomer(userNamePassword.getUserName())
                .orElseThrow(() -> new CustomerNotFoundException(userNamePassword.getUserName()));

        if (customer == null) {
            logger.error(format("Unknown Customer %s", userNamePassword.getUserName()));
            throw new UnauthorizedException();
        }
        if (!customer.doesPasswordMatch(userNamePassword.getPassword())) {
            logger.error(format("Password does not match for user %s", userNamePassword.getUserName()));
            throw new LoginException();
        }
        if (!customer.canHaveAccessTo(feature)) {
            logger.error(format("User %s does not have access to %s", userNamePassword.getUserName(), feature));
            throw new UnauthorizedException();
        }
    }

    private UserNamePassword getUserNamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));

        String userName = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new UserNamePassword(userName, password);
    }

    public String getUserUUIDForCustomer(String auth){
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(auth.substring("Basic ".length())));

        return decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));

    }
}
