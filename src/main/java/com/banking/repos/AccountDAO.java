package com.banking.repos;

import com.banking.models.UserAccounts;

public interface AccountDAO {
	
	public UserAccounts findById(int id);
	public void updateAccount(UserAccounts updateUserAccount);
	
	
}
