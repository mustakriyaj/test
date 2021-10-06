package com.example.test.dto;

import com.example.test.model.Customer;

public class AddressDto {
    private Integer addressId;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private Integer customerId;

    public AddressDto() {
        super();
    }

    public AddressDto(String city, String state, String country, String pincode, Integer customerId) {
        super();
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.customerId = customerId;
    }

    public AddressDto(Integer addressId, String city, String state, String country, String pincode, Integer customerId) {
        super();
        this.addressId = addressId;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.customerId = customerId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
