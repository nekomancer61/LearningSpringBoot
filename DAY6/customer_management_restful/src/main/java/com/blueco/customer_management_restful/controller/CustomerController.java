package com.blueco.customer_management_restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.blueco.customer_management_restful.model.Customer;
import com.blueco.customer_management_restful.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//  GET request "/api/customers/" trả về danh sách các khách hàng
    @GetMapping(value = "/customers/",produces = "application/json")
    public List<Customer> listAllCustomer(){
        List<Customer> customers = customerService.findAll();
        return customers;
    }

//  GET request "/api/customers/1" trả về khách hàng với ID 1
    @GetMapping(value = "/customers/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer findCustomerById(@RequestParam(name="id") long id){
        Customer customer = customerService.findById(id);
        
       
        return customer;
    }

//  POST request "/api/customers/" với một JSON object tạo một khách hàng mới
    @RequestMapping(value="/customers/", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder){
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

//  PUT request "/api/customers/3" với một JSON object cập nhật khách hàng có ID 3
    @RequestMapping(value="/customers/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id")long id, @RequestBody Customer customer){
        Customer currentCustomer = customerService.findById(id);
        if (currentCustomer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setId(customer.getId());
        customerService.save(currentCustomer);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }

//  DELETE request "/api/customers/3" xóa khách hàng có ID 3
    @RequestMapping(value="/customers/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id")long id){
        Customer currentCustomer = customerService.findById(id);
        if (currentCustomer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.NO_CONTENT);
    }

}
