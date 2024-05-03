package com.saas.tagntrack.service;

import com.saas.tagntrack.dto.CustomerDTO;
import com.saas.tagntrack.entity.Customer;
import com.saas.tagntrack.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepo;

    @BeforeEach
    void setup() {
        customerRepo = Mockito.mock(CustomerRepository.class);
    }

    @Test
    void addCustomer(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("test");
        customerDTO.setPassword("test");

        Customer customer = new Customer(1L, customerDTO.getName(), customerDTO.getPassword());
        Mockito.when(customerRepo.save(customer)).thenReturn(customer);

        customerDTO =  customerService.addCustomer(customerDTO);
        Assertions.assertEquals(customerDTO.getName(), customer.getName());
    }

}