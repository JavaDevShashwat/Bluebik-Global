package com.transactions.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionServiceImpl {

	@Autowired
    private RestTemplate restTemplate;
    

    public void credit(String accountId, String userId, BigDecimal amount) {
        // Call the Account and User services to retrieve the Account and User entities
        Account account = restTemplate.getForObject("http://account-service/accounts/" + accountId, Account.class);
        User user = restTemplate.getForObject("http://user-service/users/" + userId, User.class);

        // Check if the account belongs to the user
        if (!account.getUsers().contains(user)) {
            throw new IllegalArgumentException("The specified account does not belong to the specified user.");
        }

        // Calculate the new balance after the credit
        BigDecimal newBalance = account.getBalance().add(amount);

        // Check if the new balance exceeds 10 million
        if (newBalance.compareTo(BigDecimal.TEN_MILLION) > 0) {
            throw new IllegalArgumentException("The account balance cannot exceed 10 million.");
        }

        // Update the account balance by calling the Account service
        restTemplate.put("http://account-service/accounts/" + accountId, account);

        // Create a new Transaction entity to record the credit operation
        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setUserId(userId);
        transaction.setAmount(amount);
        transaction.setType(TransactionType.CREDIT);
        transactionRepository.save(transaction);
    }

    public void debit(String accountId, String userId, BigDecimal amount) {
        // Call the Account and User services to retrieve the Account and User entities
        Account account = restTemplate.getForObject("http://account-service/accounts/" + accountId, Account.class);
        User user = restTemplate.getForObject("http://user-service/users/" + userId, User.class);

        // Check if the account belongs to the user
        if (!account.getUsers().contains(user)) {
            throw new IllegalArgumentException("The specified account does not belong to the specified user.");
        }

        // Calculate the new balance after the debit
        BigDecimal newBalance = account.getBalance().subtract(amount);

        // Check if the new balance goes below zero
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The account balance cannot go below zero.");
        }

        // Update the account balance by calling the Account service
        restTemplate.put("http://account-service/accounts/" + accountId, account);

        // Create a new Transaction entity to record the debit operation
        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setUserId(userId);
        transaction.setAmount(amount);
        transaction.setType(TransactionType.DEBIT);
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByUserId(String userId) {
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
