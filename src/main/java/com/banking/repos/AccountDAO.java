package com.banking.repos;

import com.banking.service.UserAccounts;

public interface AccountDAO {
	
	public void findById();
	public void updateAccount(UserAccounts updateUserAccount);
	
}
