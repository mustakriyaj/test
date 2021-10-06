package com.example.test.service;

import com.example.test.dto.CustomerDto;
import com.example.test.exception.CustomerNotFoundException;
import com.example.test.model.Customer;

public interface CustomerService {
    public Customer addCustomer(CustomerDto customerdto);
    public Customer updateCustomer(CustomerDto customerdto) throws CustomerNotFoundException;
    public Boolean removeCustomer(Integer customerId) throws CustomerNotFoundException;
    public Customer viewCustomerById(Integer customerId) throws CustomerNotFoundException;
}
