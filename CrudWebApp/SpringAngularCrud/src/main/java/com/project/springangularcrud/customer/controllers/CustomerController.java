package com.project.springangularcrud.customer.controllers;

import com.project.springangularcrud.customer.entity.Customer;
import com.project.springangularcrud.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/customers")
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {

        @Autowired
        private CustomerService customerService;


        @GetMapping(value = "/All")
        public List<Customer> getAllCustomers(){
            return this.customerService.getAllCustomers();
        }
        @GetMapping(value = "/{id}")
        public Optional<Customer> getCustomerById(@PathVariable Long id){
            return this.customerService.getCustomerById(id);
        }
        @PostMapping(value = "/save")
        public Customer saveCustomer(@RequestBody Customer customer){
            Customer customer1 = this.customerService.addCustomer(customer);
            return  customer1;
        }

        @PutMapping(value = "/update/{id}")
        public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
            this.customerService.updateCustomer(customer,id);
        }
        @DeleteMapping(value = "/delete/{id}")
        public void deleteCustomer(@PathVariable Long id){
            this.customerService.deleteCustomer(id);
        }

}
