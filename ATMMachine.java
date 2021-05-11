package atmTransaction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//Credit card Numbers
//	1111555577772222
//	1111666677775555
//	1111444488885555
public class ATMMachine {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Person firstPerson = new Person("Alpha","100AB001");
		ATM member1= new ATM(firstPerson,100,1111555577772222L);
		Person secondPerson = new Person("Beta","100AB002");
		ATM member2 = new ATM(secondPerson,200,1111666677775555L);
		Person thirdPerson = new Person("Gamma","100AB003");
		ATM member3 = new ATM(thirdPerson,1235,1111444488885555L);
	
		ArrayList<ATM> transactions = new ArrayList<>();
		transactions.add(member1);
		transactions.add(member2);
		transactions.add(member3);
		
		System.out.println("Welcome to Wealthy Bank of Java");
		ATM customer = null;
		boolean flag=true;
		long creditCard;
		do {
			try {
			System.out.println("Enter CreditCard Number:");
			creditCard = scan.nextLong();
			for(ATM member:transactions) {
				if(member.getCreditCardNumber()==creditCard) {
					customer = member;
					flag=false;
					break;
				}
			}
			if(flag)
				System.err.println("Please!Enter a Valid Credit-card Number");
			}
			catch(InputMismatchException e)
			{
				System.err.println("Please Enter Only number");
			}
		}while(flag);
		int choice = 0;
		do {
			System.out.println("1->Show Balance\n2->Deposit\n"
					+ "3->Withdraw\n4->Swipe\n5->Exit");
			System.out.print("Your choice :");
			choice = scan.nextInt();
			switch(choice) {
			case 1:customer.showBalance(customer);
				break;
			case 2:customer.depositMoney(customer);
				break;
			case 3:customer.withdrawMoney(customer);
				break;
			case 4:customer.swipeCard(customer);
				break;
			case 5:
				break;
			default:System.out.println("Please!Enter A Valid Option");
			}
		}while(choice!=5);
	}
}
