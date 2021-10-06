package com.example.test.controller;

import com.example.test.dto.CustomerDto;
import com.example.test.exception.CustomerNotFoundException;
import com.example.test.model.Customer;
import com.example.test.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    public CustomerServiceImp customerService;

    @PostMapping("/customer/addcustomer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerDto)
    {
        Customer customer= customerService.addCustomer(customerDto);
        return new ResponseEntity<>("CUSTOMER ADDED", HttpStatus.CREATED);
    }

    @PutMapping("/customer/updatecustomer")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDto customerDto) throws CustomerNotFoundException
    {
        try {
            Customer customer=customerService.updateCustomer(customerDto);
        } catch (Exception ex) {
            throw new CustomerNotFoundException("Customer ID not found in database");
        }
        return new ResponseEntity<>("CUSTOMER DETAILS UPDATED", HttpStatus.OK);
    }

    @DeleteMapping("/customer/removecustomer/{id}")
    public ResponseEntity<String> removeCustomer(@PathVariable("id") Integer id) throws CustomerNotFoundException {
        customerService.removeCustomer(id);
        return new ResponseEntity<>("CUSTOMER DELETED", HttpStatus.OK);
    }

    @GetMapping("/customer/viewcustomerbyid/{id}")
    public ResponseEntity<Customer> viewCustomerById(@PathVariable("id") Integer id) throws CustomerNotFoundException
    {
        Customer customer = new Customer();
        try{
            customer = customerService.viewCustomerById(id);
        }
        catch (Exception ex){
            throw new CustomerNotFoundException("Costomer ID not found in database");
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
