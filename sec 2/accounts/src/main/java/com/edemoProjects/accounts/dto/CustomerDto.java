package com.edemoProjects.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Rini Dabral"
    )
    @NotEmpty(message = "name cant be null or empty")
    @Size(min=5, max=30, message="name should be between 5 and 30")
    private String name;

    @Schema(
            description = "email of the customer", example = "rini03dabral@gmail.com"
    )
    @NotEmpty(message = "email cant be null or empty")
    @Email(message = "email is not valid")
    private String email;

    @Schema(
            description = "mobile number of the customer", example = "938573037"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Accounts details of the customer", example = "Rini Dabral"
    )
    private AccountsDto accountsDto;
}
