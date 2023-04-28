package com.account.service;

import java.util.List;

import com.account.model.Account;

public interface AccountService {
	Account create(Account account);
    Account update(Account account);
    void delete(Long accountId);
    Account getById(Long accountId);
    List<Account> getAll();
    List<Account> getByUserId(Long userId);
}
