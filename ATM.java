package atmTransaction;

import  java.util.Scanner;

public class ATM extends Bank implements BankServices{
	private long creditCardNumber;

	public ATM(Person details,int balance,long creditCardNumber) {
		super(details,balance);
		this.creditCardNumber = creditCardNumber;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	private static Scanner scan = new Scanner(System.in);
	
	public void showBalance(ATM customer) {
		System.out.println("Balance USD "+customer.getBalance());
	}
	public void depositMoney(ATM customer) {
		int amount;
		System.out.print("Enter Amount to Deposit :");
		amount=scan.nextInt();
		customer.setBalance(customer.getBalance()+amount);
		System.out.println("Amount Deposited Succesfully");
		System.out.println("Balance USD "+customer.getBalance());
	}
	public void withdrawMoney(ATM customer) {
		int amount=0;
		System.out.print("Enter Amount to withdraw :");
		amount=scan.nextInt();
		if(amount%5!=0) {
			System.err.println("Please correct the amount of value."
					+ " It should be multiple of USD 5");	
		}
		else if(customer.getBalance()<(amount+customer.transactionFee(amount))) {
			System.err.println("Insufficient Balance! Please Try Again.");
		}
			
		else if(customer.checkMinimumBalance(customer,amount)) {
			System.err.println("Minimum Balance limit Reached! "
					+ "Please maintain minimum balance.");
			double charges =  customer.transactionFee(amount);
			customer.setBalance(customer.getBalance()-(amount+charges));
			System.out.println("Amount debited Successfully!");
			System.out.println("Charges USD "+charges);
			System.out.println("Balance USD"+customer.getBalance());
		}
		else {
			double charges =  customer.transactionFee(amount);
			customer.setBalance(customer.getBalance()-(amount+charges));
			System.out.println("Amount debited Successfully!");
			System.out.println("Charges USD "+charges);
			System.out.println("Balance USD"+customer.getBalance());
		}
	}
	public void swipeCard(ATM customer) {
		int amount=0;
		System.out.print("Enter Amount to withdraw :");
		amount=scan.nextInt();
		if(customer.getBalance()<amount) {
			System.err.println("Insufficient Balance! Please Try Again.");
		}
		else if(customer.checkMinimumBalance(customer,amount)) {
			System.err.println("Minimum Balance limit Reached! "
					+ "Please maintain minimum balance.");
			double cashBack = customer.cashBack(amount);
			customer.setBalance(customer.getBalance()-amount+cashBack);
			System.out.println("Amount debited Successfully");
			System.out.println("CashBack USD"+cashBack);
			System.out.println("Balance USD"+customer.getBalance());
		}
			
		else {
			double cashBack = customer.cashBack(amount);
			customer.setBalance(customer.getBalance()-amount+cashBack);
			System.out.println("Amount debited Successfully");
			System.out.println("CashBack USD"+cashBack);
			System.out.println("Balance USD"+customer.getBalance());
		}
	}
	public boolean checkMinimumBalance(ATM customer,int amount) {
		if(customer.getBalance()-amount<100)
			return false;
		else
			return true;
	}

}
