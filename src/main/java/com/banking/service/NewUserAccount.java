
package com.banking.service;

import java.util.Scanner;
import java.util.UUID;

import com.banking.models.UserAccounts;
import com.banking.utils.MainMenu;

public class NewUserAccount extends UserAccounts {

	MainMenu goToMenu = new MainMenu();
	
	Scanner scan = new Scanner(System.in);
	
	public NewUserAccount() {
		
	}
	
	//Prompts user for information to create a new user account
	public NewUserAccount(String firstName, String lastName, long phoneNum, String email) {
	
		System.out.println("Please enter your information:");
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		setEmail(email);
		
		//prompts user to check that their information is correct.
		//if there is incorrect information calls the updateAccount method from UserAccounts Class
		//to re-enter their information
		System.out.println("Is this information correct? (Y/N)");
		
		String input = scan.nextLine().toLowerCase();

		if (input == "y"){
				System.out.println("Your user account ID is "+genId());
				goToMenu.mainMenu();
		} else {
			updateUserAccount(input, input, phoneNum, input);
		}
		
	}
	
	public String genId() {
		String uniqueID = UUID.randomUUID().toString();
		return uniqueID;
	}
	

}
