package be.switchfully.eurder.customer;

import be.switchfully.eurder.customer.dto.CustomerDto;
import be.switchfully.eurder.customer.exceptions.CustomerNotFoundException;
import be.switchfully.eurder.customer.exceptions.NoCustomersInDatabaseException;
import be.switchfully.eurder.customer.domain.Customer;
import be.switchfully.eurder.customer.dto.NewCustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public void addNewCustomer(NewCustomerDto custemerDto){
        customerRepository.addNewCustomer(
                customerMapper.convertDtoToCustomer(custemerDto)
        );
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.getAllCustomers();
        if(customerList.isEmpty()){
            throw new NoCustomersInDatabaseException();
        }
        return customerMapper.mapCustomerListToCustomerDTOList(customerList);
    }

    public CustomerDto getSpecificCustomer(String customerId) {
        return customerMapper.mapCustomerToCustomerDTO(
                customerRepository.getSpecificCustomer(customerId)
                        .orElseThrow(() -> new CustomerNotFoundException(customerId))
        );
    }
}
