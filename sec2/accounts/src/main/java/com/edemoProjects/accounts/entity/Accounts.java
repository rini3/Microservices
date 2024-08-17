package com.edemoProjects.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity{

    @Column(name="customer_id")
    private Long customerId;

    @Id @Column(name="account_number")
    private Long accountNumber;

    private String account_type;
    private String branch_address;
}
