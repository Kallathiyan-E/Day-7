package atmTransaction;

public interface BankServices {
	public void showBalance(ATM customer);
	public void depositMoney(ATM customer);
	public void withdrawMoney(ATM customer);
	public void swipeCard(ATM customer);
	public boolean checkMinimumBalance(ATM customer,int amount);
}
