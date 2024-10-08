package com.edemoProjects.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold Customer's'Account information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account No. of the customer",example=""
    )
    @NotNull(message = "account number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the customer", example="Savings"
    )
    @NotNull(message = "account type can not be null or empty")
    private String account_type;

    @Schema(
            description = "Account branch address of the customer",example="New York"
    )
    @NotNull(message = "branch address can not be null or empty")
    private String branch_address;
}

