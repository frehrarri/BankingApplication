package com.banking.service;

import com.banking.models.UserAccounts;
import com.banking.repos.AccountDAO;
import com.banking.repos.AccountDAOImpl;

public class UserAccountServices {

	AccountDAO aDao = new AccountDAOImpl();

	public UserAccounts getAccountById(int id) {
		return aDao.findById(id);
	}

	public boolean deposit(double amount, UserAccounts acc) {
		if (amount < 1) {
			return false;
		}

		acc.setBalance(amount + acc.getBalance());
		if (aDao.updateAccount(acc)) {
			return true;
		}
		return false;
	}

	
	
	public void withdraw() {
	}

	
	
	public void transfer() {
	}

	
	
}