package com.example.account.Controller;

import com.example.account.CustomerClient.CustomerClient;
import com.example.account.entities.Account;
import com.example.account.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {
    private AccountRepository accountRepository;

    private CustomerClient customerClient;
    public AccountController(AccountRepository accountRepository,CustomerClient customerClient) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
    }

    @GetMapping("/account")
    public List<Account> getAccount() {
        List<Account> account= accountRepository.findAll();
        account.forEach(account1 -> account1.setCustomer(customerClient.getCustomerById(account1.getCustomerId())));
        return account;
    }
    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable String id) {
        Account account= accountRepository.findById(id).orElse(null) ;
        account.setCustomer(customerClient.getCustomerById(account.getCustomerId()));
        return account;
    }


}
