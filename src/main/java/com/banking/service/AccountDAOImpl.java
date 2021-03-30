package com.banking.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.banking.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {
	
	protected double previousBal;
	private double sumChange;
	
	UserAccounts prevBal = new UserAccounts();
	
	//deposits funds into account
	public void deposit() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
		
			String sql = "SELECT * FROM account_info";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//insert data structures & SQL Queries
		previousBal = prevBal.preBalanceSum(0);
	}
	
	
	//withdraws funds from account
	public void withdraw() {
		previousBal = prevBal.preBalanceSum(0);
		//insert data structures & SQL Queries
	}

	
	
	//transfers funds between accounts
	public void transfer() {
		previousBal = prevBal.preBalanceSum(0);
		//insert data structures & SQL Queries
	}
	
	
	
}
