package atmTransaction;

public class Person {
	private String name;
	private String accountNumber;
	
	public Person(String name, String accountNumber) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
