package com.example.test.service;

import com.example.test.dto.AddressDto;
import com.example.test.exception.AddressNotFoundException;
import com.example.test.exception.CustomerNotFoundException;
import com.example.test.model.Address;
import com.example.test.model.Customer;
import com.example.test.repository.AddressRepository;
import com.example.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImp implements AddressService{
    @Autowired
    AddressRepository addressDao;

    @Autowired
    CustomerRepository customerDao;

    public Address addAddress(AddressDto addressDto) throws CustomerNotFoundException {
        Address address = new Address();
        Optional<Customer> optCustomer = customerDao.findById(addressDto.getCustomerId());
        if (!optCustomer.isPresent())
            throw new CustomerNotFoundException("Customer ID not found in the database");
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setPincode(addressDto.getPincode());
        address.setState(addressDto.getState());
        address.setCustomer(optCustomer.get());
        return addressDao.save(address);
    }

    public Address updateAddress(AddressDto addressDto) throws CustomerNotFoundException, AddressNotFoundException {
        Optional<Address> optAddress = addressDao.findById(addressDto.getAddressId());
        if (!optAddress.isPresent())
            throw new AddressNotFoundException("Address ID not found in the database");
        Optional<Customer> optCustomer = customerDao.findById(addressDto.getCustomerId());
        if (!optCustomer.isPresent())
            throw new CustomerNotFoundException("Customer ID not found in the database");
        Address address = optAddress.get();
        Customer customer = optCustomer.get();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setPincode(addressDto.getPincode());
        address.setState(addressDto.getState());
        address.setCustomer(customer);
        return addressDao.save(address);
    }

    public Boolean removeAddress(Integer addressId) throws AddressNotFoundException {
        Optional<Address> optaddress = addressDao.findById(addressId);

        if (!optaddress.isPresent()) {
            throw new AddressNotFoundException("Address ID not found in the database");

        }
        addressDao.delete(optaddress.get());
        return true;
    }

    public Address viewAddressById(Integer addressId) throws AddressNotFoundException {
        Optional<Address> optaddress = addressDao.findById(addressId);
        if (!optaddress.isPresent()) {
            throw new AddressNotFoundException("Address ID not found in the database");

        }
        return optaddress.get();
    }

    public Address getAddressDataByCustomerId(Integer customerId) {
        Address address = addressDao.getAddressByCustomerId(customerId);
        return address;
    }
}
