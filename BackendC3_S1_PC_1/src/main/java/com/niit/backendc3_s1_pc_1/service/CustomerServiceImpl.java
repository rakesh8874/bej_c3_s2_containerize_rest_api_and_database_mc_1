package com.niit.backendc3_s1_pc_1.service;

import com.niit.backendc3_s1_pc_1.domain.Customer;
import com.niit.backendc3_s1_pc_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer register(Customer customer) {
        if(customerRepository.findById(customer.getCustomerName()).isPresent()){
            return null;
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer login(String userName, String userPass) {
        if(customerRepository.findById(userName).isPresent()){
            Customer customer = customerRepository.findById(userName).get();
            if(customer.getCustomerPassword().equals(userPass)){
                return customer;
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(String customerName) {
        if(customerRepository.findById(customerName).isPresent()){
            customerRepository.deleteById(customerName);
            return true;
        }
        return false;
    }
}
