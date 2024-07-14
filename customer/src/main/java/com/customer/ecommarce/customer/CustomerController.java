package com.customer.ecommarce.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok().body(customerService.createCustomer(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(
            @Valid @RequestBody CustomerRequest customerRequest,
            @PathVariable("id") String id
    ){
        customerService.updateCustomer(customerRequest, id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getAll(){
        return ResponseEntity.ok().body(customerService.findAllCustomers());
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customer-id") String id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existById(@PathVariable("customer-id") String id){
        return ResponseEntity.ok(customerService.isExistById(id));
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
    }

}
