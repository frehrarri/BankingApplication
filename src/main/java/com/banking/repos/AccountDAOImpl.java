package com.banking.repos;

import java.sql.Connection;
import java.sql.SQLException;

import com.banking.service.UserAccounts;
import com.banking.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void updateAccount() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM account_info";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
