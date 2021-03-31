package com.banking.service;

import java.util.Scanner;

import com.banking.utils.MainMenu;

public class UserAccounts {

	protected String firstName;
	protected String lastName;
	protected long phoneNum;
	protected String email;
	protected double totalBal;
	
	MainMenu menuOptions = new MainMenu();
	
	Scanner scan = new Scanner(System.in);

	
	//prompts user to enter information to update their account
	//if there is incorrect information calls the updateAccount method again
	public void updateUserAccount(String FirstName, String LastName, long PhoneNum, String email) {

		System.out.println("Please enter your information:");

		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		setEmail(email);

		System.out.println("Is this information correct? (Y/N)");

		String input = scan.nextLine().toLowerCase();

		if (input.equals("y")) {
			//takes user to main menu
			menuOptions.mainMenu();
		} else {
			//re-runs prompts user to put in their information
			updateUserAccount(input, input, phoneNum, input);
		}

	}

	
	
	
	// prompts user for first name and saves the information to their account
	public void setFirstName(String firstName) {
		System.out.println("What is your first name?");
		this.firstName = scan.nextLine();
	}

	public String getFirstName() {
		return firstName;
	}

	
	
	
	// prompts user for last name and saves the information to their account
	public void setLastName(String lastName) {
		System.out.println("What is your last name?");
		this.lastName = scan.nextLine();
	}

	public String getLastName() {
		return lastName;
	}

	
	
	// prompts user for phone number and saves the information to their account
	public void setPhoneNum(long phoneNum) {
		System.out.println("What is your phone number?");
		this.phoneNum = scan.nextLong();
		scan.nextLine();
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	
	
	// prompts user for email address and saves the information to their account
	public void setEmail(String email) {
		System.out.println("What is your email address?");
		this.email = scan.nextLine();
	}

	public String getEmail() {
		return email;
	}

	
	
	//returns previous total account balance
	public double preBalanceSum(double totalBal) {
		return totalBal;
	}
	

	public void deposit() {
		
	}
	

	public void withdraw() {
	}

	

	public void transfer() {
	}
	
}
