package com.customer.ecommarce.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMapper {

    public Customer toCustomer(
            CustomerRequest customerRequest
    ){
        var customer = Customer.builder()
                .address(customerRequest.address())
                .email(customerRequest.email())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .build();

        return customer;
    }

    public CustomerResponse toCustomerDto(Customer customer){
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }

    public List<CustomerResponse> toCustomersDto(List<Customer> customers){

        return customers.stream()
                .map((c) -> new CustomerResponse(
                        c.getId(),
                        c.getFirstName(),
                        c.getLastName(),
                        c.getEmail(),
                        c.getAddress()
                ))
                .toList();

    }

}
