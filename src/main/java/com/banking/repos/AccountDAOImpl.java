package com.banking.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.banking.models.UserAccounts;
import com.banking.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void updateAccount(UserAccounts updateUserAccount) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE account_info SET balance = ? WHERE account_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setDouble(updateUserAccount.getBalance());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub
		
	}


	
}
