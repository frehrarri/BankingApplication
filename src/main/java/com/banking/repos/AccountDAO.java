package com.banking.repos;

import com.banking.models.UserAccounts;

public interface AccountDAO {
	
	public void findById(int accountId);
	public void updateAccount(UserAccounts updateUserAccount);
	
	
}
