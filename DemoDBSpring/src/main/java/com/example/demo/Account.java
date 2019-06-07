package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int number;
	private String holder;
	private double balance;
	
	public double getBalance() {
		return balance;
	}

	public String getHolder() {
		return holder;
	}

	public int getNumber() {
		return number;
	}
	
	
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
		
	}
	
	public Account(double balance, String holder, int number) {
		if (balance < 0.0) {
			throw new IllegalArgumentException("Negative balances are not supported");
		}
		this.balance = balance;
		this.holder = holder;
		this.number = number;
	}


	public void withdraw(double amount) {
		if (amount < 0.0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount");
		}
		if (balance < amount) {
			throw new InsufficientFundsException(this, amount);
		}
		balance -= amount;
	}

	public void deposit(double amount) {
		if (amount < 0.0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		balance += amount;
	}

	public static void transfer(double amount, Account from, Account to) {
		boolean result = false;
		
		try {
			from.withdraw(amount);

			to.deposit(amount);

			result = true;
		} finally {
			from.audit("Transfer attempt to " + to.number
					+ ". Completion Status: " + result);
		}
	}

	public String getDetails() {
		return number + " " + holder + " " + balance;
	}

	public void audit(String message) {
		System.out.println(number + ": " + message);
	}

}
