package com.edemoProjects.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity{

    private Long customerId;

    @Column(name="account_number")
    @Id
    private Long accountNumber;

    private String account_type;
    private String branch_address;
    private String mobileNumber;
}
