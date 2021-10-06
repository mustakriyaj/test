package com.example.test.service;

import com.example.test.dto.AddressDto;
import com.example.test.exception.AddressNotFoundException;
import com.example.test.exception.CustomerNotFoundException;
import com.example.test.model.Address;

public interface AddressService {
    public Address addAddress(AddressDto addressDto) throws CustomerNotFoundException;
    public Address updateAddress(AddressDto addressDto) throws CustomerNotFoundException, AddressNotFoundException;
    public Boolean removeAddress(Integer addressId) throws AddressNotFoundException;
    public Address viewAddressById(Integer addressId) throws AddressNotFoundException;
    public Address getAddressDataByCustomerId(Integer customerId);
}
