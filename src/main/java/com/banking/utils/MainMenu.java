package com.banking.utils;

import com.banking.models.UserAccounts;
import com.banking.service.*;

import java.io.Serializable;
import java.util.Scanner;

public class MainMenu implements Serializable {

	UserAccountServices action = new UserAccountServices();
	Scanner scan = new Scanner(System.in);
	
	//Prompts user to make a choice between updating account information, making a deposit or withdraw, or transferring between accounts
	//Executes the method associated with the choice located in the AccountDAOImpl interface
	public void mainMenu() {
		
		System.out.println("Choose an option: \n"
			+ "1. Update account information.\n"
			+ "2. Make a deposit to your account.\n"
			+ "3. Withraw from your account.\n"
			+ "4. Transfer between accounts.\n"
			+ "5. Check account balance.\n"
			+ "0. Exit menu.");
		
		int select = scan.nextInt();
		scan.nextLine();

		switch (select) {

		//updates account info
		case 1:
			UserAccounts account = new UserAccounts();
			account.updateUserAccount(null, null, 0, null);
			break;
		case 2:
		//opens deposit interface
			action.deposit();
			break;
		case 3:
		//opens withdraw interface
			action.withdraw();
			break;
		case 4:
		//opens transfer interface
			action.transfer();
			break;
		case 5:
		//returns user's current account balance
			break;
		case 0:
			System.out.println("Thank you for using the Easy Banking application.");
			StartMenu returnToStart = new StartMenu();
			returnToStart.startMenu();
			break;
		default:
			System.out.println("Invalid option. Please try again.\nSelect a number.");
			mainMenu();
			break;
		}
		mainMenu();
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
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
		MainMenu other = (MainMenu) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
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
		return "MainMenu [action=" + action + ", scan=" + scan + "]";
	}

	
	
	
	
	
}
