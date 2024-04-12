package be.switchfully.eurder.customer;

import be.switchfully.eurder.customer.domain.Customer;
import be.switchfully.eurder.customer.dto.CustomerDto;
import be.switchfully.eurder.customer.dto.NewCustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer convertDtoToCustomer(NewCustomerDto newCustomerDto) {
        return new Customer(newCustomerDto.getFirstName(),
                            newCustomerDto.getLastName(),
                            newCustomerDto.getEmail(),
                            newCustomerDto.getAddress(),
                            newCustomerDto.getPhone(),
                            newCustomerDto.getPassword());
    }

    public List<CustomerDto> mapCustomerListToCustomerDTOList(List<Customer> customerList) {
        return customerList.stream().map(this::mapCustomerToCustomerDTO).collect(Collectors.toList());
    }

    public CustomerDto mapCustomerToCustomerDTO(Customer customer) {
        return new CustomerDto(customer.getCustomerId().toString(),
                                customer.getFirstName(),
                                customer.getLastName(),
                                customer.getEmail(),
                                customer.getPhoneNumber(),
                                customer.getAddress());
    }
}
