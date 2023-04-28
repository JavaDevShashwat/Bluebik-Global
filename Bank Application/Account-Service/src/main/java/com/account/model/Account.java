package com.account.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	private Long accountId;
    private BigDecimal balance;
    
    private List<Integer> users;
}
