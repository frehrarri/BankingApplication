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
	public void findById(String genId) {
		
		try (Connection conn=ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM account_info WHERE account_id = "+genId+";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				UserAccounts acc = new UserAccounts();
				acc.setUid(result.getString("account_id"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	
}
