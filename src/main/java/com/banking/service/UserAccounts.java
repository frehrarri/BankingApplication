package com.banking.service;

import java.io.Serializable;
import java.util.Scanner;

import com.banking.utils.MainMenu;

public class UserAccounts implements Serializable {

	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;
	private double balance;
	
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

	
	
	//returns account balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	

	public void deposit() {
		
	}
	

	public void withdraw() {
	}

	

	public void transfer() {
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((menuOptions == null) ? 0 : menuOptions.hashCode());
		result = prime * result + (int) (phoneNum ^ (phoneNum >>> 32));
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
		UserAccounts other = (UserAccounts) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (menuOptions == null) {
			if (other.menuOptions != null)
				return false;
		} else if (!menuOptions.equals(other.menuOptions))
			return false;
		if (phoneNum != other.phoneNum)
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
		return "UserAccounts [firstName=" + firstName + ", lastName=" + lastName + ", phoneNum=" + phoneNum + ", email="
				+ email + ", balance=" + balance + ", menuOptions=" + menuOptions + ", scan=" + scan + "]";
	}
	
	
	
}
