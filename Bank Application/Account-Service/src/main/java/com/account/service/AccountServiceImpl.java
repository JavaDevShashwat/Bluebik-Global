package com.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.model.Account;
import com.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
    private AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account getById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getByUserId(Long userId) {
        List<Account> accounts = getAll();
        
        List<Account> users = new ArrayList<>();
        
        for (Account account : accounts) {
			users.add((Account) ((Account) accounts.stream()).getUsers().stream().filter(user -> user.equals(userId)).collect(Collectors.toList()));
		}
        
        return users;
    }
}
