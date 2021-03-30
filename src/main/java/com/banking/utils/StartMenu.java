package com.banking.utils;

import java.util.Scanner;

import com.banking.service.NewUserAccount;

public class StartMenu {

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
			account.updateAccount(null, null, 0, null);
		} else {
			System.out.println("Invalid entry. Please try again.");
			startMenu();
		}
		
		
	}
}
