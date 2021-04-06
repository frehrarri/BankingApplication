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
			+ "5. Check account balance and information.\n"
			+ "0. Exit menu.");
		
		int select = scan.nextInt();
		scan.nextLine();

		switch (select) {

		case 0:
		//exits main menu to start menu
			System.out.println("Thank you for using the Easy Banking application.");
			
			StartMenu returnToStart = new StartMenu();
			returnToStart.startMenu();
			break;
		//updates account info
		case 1:
			UserAccounts account = new UserAccounts();
			System.out.println("What is your first name?");
			String firstName = scan.nextLine();
			
			System.out.println("What is your last name?");
			String lastName = scan.nextLine();
			
			System.out.println("What is your phone number?");
			long phone = scan.nextLong();
			scan.nextLine();
			
			System.out.println("What is your email address?");
			String email = scan.nextLine();
			
			account.updateUserAccount(firstName, lastName, phone, email);
			break;
		case 2:
		//opens deposit interface
			System.out.println("What is the account number of the account you wish to make a deposit to?");
			
			int depositResponse = scan.nextInt();
			scan.nextLine();
			UserAccounts depositAccount = action.getAccountById(depositResponse);
			
			System.out.println("How much do you wish to deposit into account number " + depositAccount.getUid() + "?");
			
			double deposit = scan.nextDouble();
			scan.nextLine();
			
			if (action.deposit(deposit, depositAccount)) {
				System.out.println("Your deposit was successful!");
			} else {
				System.out.println("Something went wrong. Please verify you are depositing a positive amount and try again.");
			}
			break;
		case 3:
		//opens withdraw interface
			System.out.println("What is the account number of the account you wish to withdraw from?");
			
			int withdrawResponse = scan.nextInt();
			scan.nextLine();
			UserAccounts withdrawAccount = action.getAccountById(withdrawResponse);
			
			System.out.println("How much do you wish to withdraw from account number " + withdrawAccount.getUid() + "?");
			
			double withdraw = scan.nextDouble();
			scan.nextLine();
			
			if (action.withdraw(withdraw, withdrawAccount)) {
				System.out.println("Your withdraw was successful!");
			} else {
				System.out.println("Something went wrong. Please verify you are depositing a postive amount and try again.");
			}
			break;
		case 4:
		//opens transfer interface
			System.out.println("What is the account number of the account you wish to transfer from?");
			
			//gets the id of the account we will be transferring from
			int transferFrom = scan.nextInt();
			scan.nextLine();
			UserAccounts transferFromAccount = action.getAccountById(transferFrom);
			
			//gets the id of the account we will be transferring to
			System.out.println("What is the account number of the account you wish to transfer to?");
			int transferTo = scan.nextInt();
			scan.nextLine();
			UserAccounts transferToAccount = action.getAccountById(transferTo);
			
			System.out.println("How much do you wish to transfer from account number " + transferFromAccount.getUid() + "?");
			
			double transfer = scan.nextDouble();
			scan.nextLine();
			
			if (action.transfer(transfer, transferFromAccount, transferToAccount)) {
				System.out.println("Your transfer was successful!");
			} else {
				System.out.println("Something went wrong. Please verify you are depositing a postive amount and try again.");
			}
			break;
		case 5:
		//returns user's current account balance and information
			System.out.println("What is the account number?");
			
			int response = scan.nextInt();
			scan.nextLine();
			account = action.getAccountById(response);
			
			System.out.println("Here is your account: " + account.toString());
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
