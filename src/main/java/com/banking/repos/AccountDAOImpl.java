package com.banking.repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.banking.models.UserAccounts;
import com.banking.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean updateAccount(UserAccounts updateUserAccount) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE account_info SET account_balance = ? WHERE account_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int index = 0;
			ps.setDouble(++index, updateUserAccount.getBalance());
			ps.setInt(++index, updateUserAccount.getUid());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public UserAccounts findById(int accountId) {
		
		try (Connection conn=ConnectionUtil.getConnection()){
			
			//chooses the row primary key in our database we will be saving our changes to
			String sql = "SELECT * FROM account_info WHERE account_id = "+accountId+";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				
				UserAccounts acc = new UserAccounts();
				
				//saves our account ID to our database by calling the setUid method from UserAccounts class
				acc.setUid(result.getInt("account_id"));
				//saves our account balance to database by calling setBalance method from UserAccounts class
				acc.setBalance(result.getDouble("account_balance"));
				return acc;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
}
