package com.banking.utils;

import java.io.Serializable;
import java.util.Scanner;

import com.banking.service.NewUserAccount;

public class StartMenu implements Serializable{

	//creates objects to reference our methods
	NewUserAccount account = new NewUserAccount();
	MainMenu menuOptions = new MainMenu();
	
	Scanner scan = new Scanner(System.in);
	
	//prompts user to see if they have existing account
	//if they have an existing account prompts them to enter their credentials
	//if they do not have an account prompts them to create one
	public void startMenu() {
		
		System.out.println("Do you have an existing account? (Y/N)");
		String select = scan.nextLine().toLowerCase();

		if (select.equals("y")) {
			System.out.println("Please enter your username and password");
			//insert authentication service
			//after authentication goes to main menu
			menuOptions.mainMenu();
		} else if (select.equals("n")){
			//passes in our updateAccount method from UserAccounts class to our newAccount object
			account.updateUserAccount(null, null, 0, null);
		} else {
			System.out.println("Invalid entry. Please try again.");
			startMenu();
		}
		
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((menuOptions == null) ? 0 : menuOptions.hashCode());
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StartMenu other = (StartMenu) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (menuOptions == null) {
			if (other.menuOptions != null)
				return false;
		} else if (!menuOptions.equals(other.menuOptions))
			return false;
		if (scan == null) {
			if (other.scan != null)
				return false;
		} else if (!scan.equals(other.scan))
			return false;
		return true;
		
		
		
	}

	@Override
	public String toString() {
		return "StartMenu [account=" + account + ", menuOptions=" + menuOptions + ", scan=" + scan + "]";
	}
}
