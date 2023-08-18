package com.internship.task3;

public class UserBank {
	private double balance;
	private int accountNumber;
	private int pin;
	UserBank(int account,int pin){
		balance=0;
		accountNumber=account;
		this.pin=pin;
	}
	public double getBalance() {
		return balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public int getPin() {
		return this.pin;
	}
	public String withdraw(int amount) {
		if(amount>balance) {
			return "Unsufficient Balance to Withdraw";
		}else {
			balance-=amount;
			return "Rs. "+amount+" has been withdrawn, Available Balance: "+balance;
		}
	}
	public String deposit(int amount) {
		balance+=amount;
		return "Rs. "+amount+" has been deposited, Total Balance: "+balance;
	}
	
}
