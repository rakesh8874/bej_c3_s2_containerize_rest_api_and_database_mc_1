package com.niit.backendc3_s1_pc_1.controller;
import com.niit.backendc3_s1_pc_1.domain.Customer;
import com.niit.backendc3_s1_pc_1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

    ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.register(customer), HttpStatus.CREATED);
    }
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomersDetails(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    @DeleteMapping("/customer/{customerName}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable String customerName){
        return new ResponseEntity<>(customerService.deleteCustomer(customerName),HttpStatus.OK);
    }

}
