package com.niit.backendc3_s1_pc_1.service;

import com.niit.backendc3_s1_pc_1.domain.Customer;

import java.util.List;

public interface ICustomerService {

    Customer register(Customer customer);
    Customer login(String userName, String userPass);
    List<Customer> getAllCustomers();
    boolean deleteCustomer(String customerId);

}
