package com.edemoProjects.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "name cant be null or empty")
    @Size(min=5, max=30, message="name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "email cant be null or empty")
    @Email(message = "email is not valid")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
