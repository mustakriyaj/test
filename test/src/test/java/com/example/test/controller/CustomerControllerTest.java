package com.example.test.controller;

    
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
        
import java.util.ArrayList;
import java.util.List;


import com.example.test.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
        
import com.example.test.model.Customer;
import com.example.test.service.CustomerService;
        
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class CustomerControllerTest {
        
    private MockMvc mockMvc;
        
    @Autowired
    private WebApplicationContext webApplicationContext;
        
    @Autowired
    private CustomerService customerService;
        
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
        
    @Test
    public void testGetCustomerById() throws Exception {
        mockMvc.perform(get("/customer/viewcustomerbyid/4"))
                .andExpect(status().isOk());
    }
        
    @Test
    public void testAddCustomer() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerDto customerDto = new CustomerDto("mustak", "riyaj", "8001553961", "mriyaj3530@gmail.com");
        mockMvc.perform(post("/customer/addcustomer").contentType("application/json").content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string("CUSTOMER ADDED"));
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerDto customerDto = new CustomerDto(1,"mustak", "riyaj", "8001553961", "mriyaj3530@gmail.com");
        mockMvc.perform(put("/customer/updatecustomer").contentType("application/json").content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("CUSTOMER DETAILS UPDATED"));
    }
}
