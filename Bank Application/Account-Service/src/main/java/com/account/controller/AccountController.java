package com.account.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Account;
import com.account.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
    private AccountRepository accountRepository;

    // API to create an account
    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    // API to get account details by ID
    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable("id") Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    // API to update account balance
    @PutMapping("/accounts/{id}")
    public Account updateAccountBalance(@PathVariable("id") Long accountId, @RequestParam("amount") BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account != null) {
            BigDecimal updatedBalance = account.getBalance().add(amount);
            if (updatedBalance.compareTo(BigDecimal.ZERO) >= 0 && updatedBalance.compareTo(new BigDecimal("10000000")) <= 0) {
                account.setBalance(updatedBalance);
                return accountRepository.save(account);
            }
        }
        return null;
    }
}
