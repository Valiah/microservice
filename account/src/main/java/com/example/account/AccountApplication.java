package com.example.account;

import com.example.account.CustomerClient.CustomerClient;
import com.example.account.entities.Account;
import com.example.account.entities.CurrencyType;
import com.example.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

    public static void main(String[] args) {

        SpringApplication.run(AccountApplication.class, args);


    }

    @Bean
    CommandLineRunner commandLineRunner (AccountRepository accountRepository, CustomerClient customerClient) {
        return args -> {
            customerClient.getCustomers().forEach(
                    customer -> {
                        Account account = Account.builder()
                                .balance(100D)
                                .currency(CurrencyType.EUR)
                                .dateCreated(LocalDate.now())
                                .customerId(customer.getId())
                                .build();
                        accountRepository.save(account);
                    }
                    );
        };
    }
};





