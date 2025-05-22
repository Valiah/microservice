package com.example.account.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Currency;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Builder
@ToString

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double balance;
    private LocalDate dateCreated;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    @Transient
    private Customer customer;
    private Long customerId;

}
