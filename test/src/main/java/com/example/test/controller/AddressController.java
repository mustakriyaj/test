package com.example.test.controller;

import com.example.test.dto.AddressDto;
import com.example.test.exception.AddressNotFoundException;
import com.example.test.exception.CustomerNotFoundException;
import com.example.test.model.Address;
import com.example.test.service.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    public AddressServiceImp addressService;

    @PostMapping("address/addaddress")
    public ResponseEntity<String> addAddress(@RequestBody AddressDto addressDto) throws CustomerNotFoundException {
        Address address = addressService.addAddress(addressDto);
        return new ResponseEntity<>("ADDRESS ADDED", HttpStatus.CREATED);
    }

    @PutMapping("address/updateaddress")
    public ResponseEntity<String> updateAddress(@RequestBody AddressDto addressDto) throws AddressNotFoundException, CustomerNotFoundException {
        Address address = addressService.updateAddress(addressDto);
        return new ResponseEntity<>("ADDRESS UPDATED",HttpStatus.OK);
    }

    @DeleteMapping("address/removeaddress/{id}")
    public ResponseEntity<String> removeAddress(@PathVariable("id") Integer id) throws AddressNotFoundException {
        addressService.removeAddress(id);
        return new ResponseEntity<>("ADDRESS REMOVED", HttpStatus.OK);
    }

    @GetMapping("address/viewaddressbyid/{id}")
    public ResponseEntity<Address> viewAddressById(@PathVariable("id") Integer id) throws AddressNotFoundException {
        Address address = addressService.viewAddressById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("address/getaddressbycustomerid/{id}")
    public ResponseEntity<Address> viewAddressByCustomerId(@PathVariable("id") Integer id)
    {
        Address address = addressService.getAddressDataByCustomerId(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
