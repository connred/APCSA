package problem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	private List<Transaction> transactions = new ArrayList<>();
	private static double annualInterestRate = 0;
	private String customer;
	private double balance = 0;
	private int id = 0;
	private Date dateCreated = new Date();

	public Account() {
		dateCreated = new Date();
	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}

	public Account(String customer, int id, double balance) {
		this.customer = customer;
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public static double getAnnualInterestRate() {
		return annualInterestRate / 100.0;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static void setAnnualInterestRate(double rate) {
		annualInterestRate = (rate);
	}

	public double getMonthlyInterest() {
		return getMonthlyInterestRate() * balance;
	}

	public double getMonthlyInterestRate() {
		return annualInterestRate / 100 / 12;
	}

	public double withdraw(double amount) {
		if (amount < balance) {
			balance -= amount;
			Transaction test = new Transaction('W', amount, balance, "Withdraw $" + amount);
			transactions.add(test);
		}
		return balance;
	}

	public double deposit(double amount) {
		balance += amount;
		Transaction test = new Transaction('D', amount, balance, "Deposit $" + amount);
		transactions.add(test);
		return balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public String getCustomer() {
		return customer;
	}

	public String toString() {
		String x = "ID: " + id + "\tName: " + customer + "\tBalance: $" + balance + "\n";

		for (int i = 0; i < transactions.size(); i++) {
			x += transactions.get(i);
		}
		return x;
	}
}
