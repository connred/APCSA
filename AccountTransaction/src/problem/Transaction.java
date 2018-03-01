package problem;
import java.util.Date;

public class Transaction {
	private char type;
	private Date date = new Date();
	private double amount = 0;
	private double balance;
	private String description;
	public Transaction (char type, double amount, double balance, String description) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		this.date = new Date();
	}
	public String toString() {
		String x = date + "\tType: " + type + "\tAmount: $" + amount + "\tBalance: $" + balance + "\tDescription: " + description + "\n";
		return x;
	}
}
