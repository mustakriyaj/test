package com.example.test.repository;

import com.example.test.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("FROM Address a inner Join a.customer c WHERE c.customerId = :customerId")
    public Address getAddressByCustomerId(@Param("customerId") Integer customerId);
}
