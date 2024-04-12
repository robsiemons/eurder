package be.switchfully.eurder.customer;


import be.switchfully.eurder.customer.domain.Customer;
import be.switchfully.eurder.customer.dto.CustomerDto;
import be.switchfully.eurder.customer.dto.NewCustomerDto;
import be.switchfully.eurder.security.Feature;
import be.switchfully.eurder.security.SecurityService;
import be.switchfully.eurder.security.exceptions.LoginException;
import be.switchfully.eurder.security.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static be.switchfully.eurder.security.Feature.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;
    private final SecurityService securityService;
    public CustomerController(CustomerService customerService, SecurityService securityService) {
        this.customerService = customerService;
        this.securityService = securityService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("new")
    public void addNewCustomer(@RequestBody NewCustomerDto newCustomerDto){
        customerService.addNewCustomer(newCustomerDto);
    }

    @GetMapping("list")
    public List<CustomerDto> getAllCustomers(@RequestHeader(value = "Authorization") String auth){
        try {
            securityService.validateAdminAuthorization(auth, VIEW_CUSTOMERS);
        } catch (UnauthorizedException | LoginException exception) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage(), exception);
        }
        return customerService.getAllCustomers();

    }

    @GetMapping("list/{customerId}")
    public CustomerDto getSpecificCustomer(@RequestHeader(value = "Authorization") String auth,
                                              @RequestParam String customerId){
        try {
            securityService.validateCustomerAuthorization(auth, Feature.VIEW_CUSTOMERS);
        } catch (UnauthorizedException | LoginException exception) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage(), exception);
        }
        return customerService.getSpecificCustomer(customerId);

    }
}
