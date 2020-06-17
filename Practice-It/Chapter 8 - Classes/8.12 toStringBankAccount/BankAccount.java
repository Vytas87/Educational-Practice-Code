// Each BankAccount object represents one user's account
// information including name and balance of money.

public class BankAccount {
	public String name;
	public double balance;

	public final void deposit(double amount) {
		balance = balance + amount;
	}

	public final void withdraw(double amount) {
		balance = balance - amount;
	}
	
// YOUR CODE GOES HERE

}
