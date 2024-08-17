package com.edemoProjects.accounts.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @NotNull(message = "account number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "account number must be 10 digits")
    private Long accountNumber;

    @NotNull(message = "account type can not be null or empty")
    private String account_type;

    @NotNull(message = "branch address can not be null or empty")
    private String branch_address;
}

