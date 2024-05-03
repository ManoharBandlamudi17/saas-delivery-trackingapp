package com.saas.tagntrack.service;

import com.saas.tagntrack.dto.CustomerDTO;
import com.saas.tagntrack.entity.Customer;
import com.saas.tagntrack.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = getCustomer(customerDTO);
        customerRepository.save(customer);
        customerDTO.setId(customer.getId());
        return customerDTO;
    }

    private Customer getCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        return customer;
    }


}
