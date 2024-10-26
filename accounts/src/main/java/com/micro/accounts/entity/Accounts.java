package com.micro.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity{

    @Id
    private Long accountNumber;

    @Column(name = "customer_id")
    private Long customerId;

    private String accountType;

    private String branchAddress;
}
