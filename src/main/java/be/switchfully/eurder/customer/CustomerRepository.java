package be.switchfully.eurder.customer;

import be.switchfully.eurder.customer.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private final List<Customer> customerList;

    public CustomerRepository() {
        this.customerList = new ArrayList<>();;
    }

    public void addNewCustomer(Customer customer){
        customerList.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerList;
    }

    public Optional<Customer> getSpecificCustomer(String customerId) {
        return customerList.stream().filter(customer -> customer.getCustomerId().toString().equals(customerId)).findFirst();
    }
}
