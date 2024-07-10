package com.nipuna.customer.entity.dto;

import com.nipuna.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {


    private String id;
    @NotNull( message = "First name cannot be null")
    @Size(min = 3, max = 15, message = "minimum must be 3 and maximum must be 15")
    private String firstname;
    @NotNull(message = "Last name must not be null")
    private String lastname;
    @Email(message = "Not a valid email")
    private String email;
    private Address address;
}
