package atmTransaction;

public class Bank {
	private Person details;
	private double balance;

	public Bank(Person details,double balance) {
		this.details = details;
		this.balance = balance;
	}
	
	public Person getDetails() {
		return details;
	}

	public void setDetails(Person details) {
		this.details = details;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double transactionFee(int amount) {
		if(amount<100)
			return amount*0.02;
		else
			return amount*0.04;
	}
	
	public double cashBack(int amount) {
		return amount*0.01;
	}
}
