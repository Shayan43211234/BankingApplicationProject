import java.util.*;
public class BankingApplication
{
	public static void main(String[]args)
	{
		BankAccount bank=new BankAccount();
		bank.showMenu();
	}
}
class BankAccount
{
	int balance;
	int previousTransaction;
	String customerName=new String();
	String customerID=new String();
	
	void depositMoney(int amount)
	{
		if(amount != 0)
		{
			balance=balance+amount;
			previousTransaction=amount;
		}
	}
	
	void withdrawMoney(int amount)
	{
		if(amount != 0)
		{
			if(balance>amount)
			{
				balance=balance-amount;
				previousTransaction=-amount;
			}
			else
			{
				System.out.println("Your Remaing Balance is "+balance+". You Can't Withdraw More than that. e.g. "+amount);
			}
		}
	}
		
	void getPreviousTransactionDetails()
	{
		if(previousTransaction > 0)
			{
				System.out.println("Your Last Transaction Found Deposit: "+previousTransaction);
			}
		else
			{
				if(previousTransaction < 0)
					{
						System.out.println("Your Last Transaction Found Withdraw: "+Math.abs(previousTransaction));
					}
				else
					{
						System.out.println("No transaction occured");
					}
			}		
	}
	
	void showMenu()
	{
		char option;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\nWelcome To Our Branch :)\n");
		
		System.out.println("Please Enter Your Name: ");
		customerName=sc.nextLine();
				
		System.out.println("\nPlease Enter Your Password: ");
		customerID=sc.nextLine();
				
		System.out.println("\nWelcome "+customerName+" Your Password is "+customerID);
				
		System.out.println("\nA. Check Balance");
		System.out.println("B. Deposit Money");
		System.out.println("C. Withdraw Money");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		System.out.println("\n");
		
		do
		{
			System.out.println("==========================================================================");
			System.out.println("Enter an Option");
			System.out.println("==========================================================================");
			option=sc.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
				
				case 'A':
						System.out.println("==========================================================================");
						System.out.println("Balance = "+balance);
						System.out.println("==========================================================================");
						System.out.println("\n");
						break;
						
				case 'B':
						System.out.println("==========================================================================");
						System.out.println("Enter an Amount to Deposit:");
						System.out.println("==========================================================================");
						int amount1=sc.nextInt();
						depositMoney(amount1);
						System.out.println("\n");
						break;
						
				case 'C':
						System.out.println("==========================================================================");
						System.out.println("Enter an Amount to Withdraw:");
						System.out.println("==========================================================================");
						int amount2=sc.nextInt();
						withdrawMoney(amount2);
						System.out.println("\n");
						break;
						
				case 'D':
						System.out.println("==========================================================================");
						getPreviousTransactionDetails();
						System.out.println("==========================================================================");
						System.out.println("\n");
						break;
						
				case 'E':
						System.out.println("**************************************************************************");
						break;
						
				default:
						System.out.println("Error Found 404! :( Please Try Again :)\n");
						break;
			}
			
		}while(option != 'E');
		
		System.out.println("Thank you! For Using Our Branch Service :)");
		System.out.println("**************************************************************************");
	}
}