package com.banking.utils;

import com.banking.repos.AccountDAOImpl;
import com.banking.service.*;
import java.util.Scanner;

public class MainMenu {

	AccountDAOImpl impl = new AccountDAOImpl();
	//UserAccounts changeInfo = new UserAccounts();
	Scanner scan = new Scanner(System.in);
	
	//Prompts user to make a choice between updating account information, making a deposit or withdraw, or transferring between accounts
	//Executes the method associated with the choice located in the AccountDAOImpl interface
	public void mainMenu() {
		
		System.out.println("Choose an option:");
		System.out.println("1. Update account information.");
		System.out.println("2. Make a deposit to your account.");
		System.out.println("3. Withraw from your account.");
		System.out.println("4. Transfer between accounts.");
		System.out.println("5. Check account balance.");
		System.out.println("0. Exit menu.");
		
		int select = scan.nextInt();
		scan.nextLine();

		switch (select) {

		//updates account info
		case 1:
			//changeInfo.updateAccount(null, null, 0, null);
			break;
		case 2:
		//opens deposit interface
			impl.deposit();
			break;
		case 3:
		//opens withdraw interface
			impl.withdraw();
			break;
		case 4:
		//opens transfer interface
			impl.transfer();
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

}
