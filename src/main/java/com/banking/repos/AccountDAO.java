package com.banking.repos;

import com.banking.models.UserAccounts;

public interface AccountDAO {
	
	public void findById(String genId);
	public void updateAccount(UserAccounts updateUserAccount);
	
}
