package com.transactions.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transaction;

public interface TransactionService {

	void credit(Long accountId, Long userId, BigDecimal amount);
    void debit(Long accountId, Long userId, BigDecimal amount);
    List<Transaction> getTransactionsByUserId(Long userId);
    List<Transaction> getTransactionsByAccountId(Long accountId); 
}
