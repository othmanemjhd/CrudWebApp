package com.project.springangularcrud.customer.services;

import com.project.springangularcrud.customer.entity.Customer;
import com.project.springangularcrud.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return this.customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer){
       return this.customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, long id){
      Customer customer1 = this.customerRepository.findById(id).get();
      customer1.setCustomerAddress(customer.getCustomerAddress());
      customer1.setPhoneNumber(customer.getPhoneNumber());
      customer1.setEmail(customer.getEmail());
        return this.customerRepository.save(customer1);
    }

    public void deleteCustomer(Long id){
            this.customerRepository.deleteById(id);
    }

}
