package be.switchfully.eurder.customer;

import be.switchfully.eurder.item.ItemMapper;
import be.switchfully.eurder.item.ItemRepository;
import be.switchfully.eurder.item.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static be.switchfully.eurder.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    CustomerService customerService;
    CustomerMapper mockedCustomerMapper;
    CustomerRepository mockedCustomerRepository;

    @BeforeEach
    void setUp() {
        mockedCustomerRepository = Mockito.mock(CustomerRepository.class);
        mockedCustomerMapper = Mockito.mock(CustomerMapper.class);
        customerService = new CustomerService(mockedCustomerRepository, mockedCustomerMapper);
    }

    @Test
    void givenNewCustomerDto_whenCreatingNewCustomer_thenCustomerIsCreated() {
        //given
        Mockito.when(mockedCustomerMapper.convertDtoToCustomer(NEW_CUSTOMER_DTO)).thenReturn(CUSTOMER);
        //When
        customerService.addNewCustomer(NEW_CUSTOMER_DTO);
        //then
        Mockito.verify(mockedCustomerRepository).addNewCustomer(CUSTOMER);
    }

    @Test
    void given2Customers_whenLookingUpAllCustomers_thenShowListOfCustomers() {
        //given
        Mockito.when(mockedCustomerMapper.convertDtoToCustomer(NEW_CUSTOMER_DTO)).thenReturn(CUSTOMER);
        Mockito.when(mockedCustomerMapper.convertDtoToCustomer(NEW_CUSTOMER_DTO2)).thenReturn(CUSTOMER2);
        //when
        customerService.addNewCustomer(NEW_CUSTOMER_DTO);
        customerService.addNewCustomer(NEW_CUSTOMER_DTO2);
        //then
        //TODO add verification that I see all customers
    }

    @Test
    void given2Customers_whenLookingUpSpecificCustomer_thenShowSpecificCustomerDetails() {
        //given
        Mockito.when(mockedCustomerMapper.convertDtoToCustomer(NEW_CUSTOMER_DTO)).thenReturn(CUSTOMER);
        Mockito.when(mockedCustomerMapper.convertDtoToCustomer(NEW_CUSTOMER_DTO2)).thenReturn(CUSTOMER2);
        //when
        customerService.addNewCustomer(NEW_CUSTOMER_DTO);
        customerService.addNewCustomer(NEW_CUSTOMER_DTO2);
        customerService.getSpecificCustomer();/*TODO How do I get specific UUID?*/
        //then
        //TODO add verification to get a specific customer
    }
}