package com.banking.repos;

import com.banking.models.UserAccounts;

public interface AccountDAO {
	
	public void findById(int id);
	public void updateAccount(UserAccounts updateUserAccount);
	
	
}
