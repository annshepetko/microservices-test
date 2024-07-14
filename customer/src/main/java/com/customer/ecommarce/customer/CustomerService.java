package com.customer.ecommarce.customer;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public String createCustomer(CustomerRequest customerRequest){
        Customer customer = customerRepository.save(customerMapper.toCustomer(customerRequest));

        return customer.getId();
    }

    @Transactional
    public void updateCustomer(CustomerRequest customerRequest, String id){
        Customer customer = customerRepository.findById(id).orElseThrow();
        mergeCustomer(customer, customerRequest);

    }

    public List<CustomerResponse> findAllCustomers(){
        List<CustomerResponse> customers = customerMapper.toCustomersDto(customerRepository.findAll());
        return customers;
    }

    public Boolean isExistById(String id){
        return customerRepository.findById(id).isPresent();
    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }

    public CustomerResponse findById(String id){

        return customerRepository.findById(id)
                .map(customerMapper::toCustomerDto)
                .orElseThrow();
    }

    private void mergeCustomer(Customer customer, CustomerRequest customerRequest){
        if (StringUtils.isNotBlank(customerRequest.email())){
            customer.setEmail(customerRequest.email());
        }
        if (StringUtils.isNotBlank(customerRequest.firstName())){
            customer.setFirstName(customerRequest.firstName());
        }
        if (StringUtils.isNotBlank(customerRequest.lastName())){
            customer.setLastName(customerRequest.lastName());
        }
        if (customerRequest.address() != null){
            customer.setAddress(customerRequest.address());
        }
    }


}

