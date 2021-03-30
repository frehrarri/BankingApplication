
package com.banking.service;

import java.util.Scanner;

public class NewUserAccount extends UserAccounts {

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
				//MainMenu
		} else {
			updateAccount(input, input, phoneNum, input);
		}
		
	}
	
	

}
