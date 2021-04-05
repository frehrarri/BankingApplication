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
	public void updateAccount(UserAccounts updateUserAccount) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE account_info SET balance = ? WHERE account_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int index = 0;
			ps.setDouble(++index, updateUserAccount.getBalance());
			ps.setNull(++index, java.sql.Types.INTEGER);
			ps.setString(++index,  updateUserAccount.getUid());
			
			ps.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserAccounts findById() {
		
		UserAccounts acc = new UserAccounts();
		
		try (Connection conn=ConnectionUtil.getConnection()){
			
			//chooses the row primary key in our database we will be saving our changes to
			String sql = "SELECT * FROM account_info WHERE bank_id = "+acc.getUid()+";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				
				//saves our generated user ID to our database by calling the setUid method from UserAccounts class
				acc.setUid(result.getString("account_id"));
				//saves our balance to database by calling setBalance method from UserAccounts class
				acc.setBalance(result.getDouble("account_balance"));
				return acc;
			} else {
				return acc;
			}
			
			//return acc;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return acc;
		}
		
	}


	
}
