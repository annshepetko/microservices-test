package com.customer.ecommarce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record CustomerRequest(

        @NotNull(message = "customer firstname is required")
        String firstName,

        @NotNull(message = "customer lastname is required")
        String lastName,

        @Email
        @NotNull(message = "customer email is required")
        String email,

        Address address
) {
}
