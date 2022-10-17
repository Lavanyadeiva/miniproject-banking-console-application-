package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank_Process {
    //to get the customer name from the customer array list for the given cust id
	static String getCustName(String custid,ArrayList<Customer_Details> list) {
		
		String name="";
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCust_id().equals(custid)) {
				name=list.get(i).getCust_name();
			}
		}
		
		return name;  
	}
	
	//to get the balance from account array list for the given accnt num
	static double getBalance(String acctno,ArrayList<Customer_Details> CustList,ArrayList<Account_Details> AcctList) {
		String custid="",name="";
		double balance=0;
		for(int i=0;i<AcctList.size();i++) {
			if(AcctList.get(i).getAccount_no().equals(acctno)) {
				custid=AcctList.get(i).getCust_id();
				balance=AcctList.get(i).getBalance();
			}
		}
	      name=getCustName(custid, CustList);
		System.out.println("Customer ID:"+custid
					+" Customer Name:"+name
					+" Balance:"+balance);
			System.out.println("-----------------------------------------------------------");
			System.out.println();

		return balance;
	}
	public static void main(String[] args) {
		
		double tran_amount;
	    ArrayList<Customer_Details> custList=new ArrayList<Customer_Details>();
	    ArrayList<Account_Details> acctList=new ArrayList<Account_Details>();
	   
	    
	    Scanner scan=new Scanner(System.in);
	  //menu driven template
	  		while(true){
	  			System.out.println("1.Create Customer, Enter value 1");
	  			System.out.println("2.Create Account, Enter value 2");
	  			System.out.println("3.Withdraw Money, Enter value 3");
	  			System.out.println("4.Deposit Money, Enter value 4");
	  			System.out.println("5.List of Customer details, Enter value 5");
	  			System.out.println("6.List of Account details, Enter value 6");
	  			System.out.println("To Exit, Enter value 9");
	  			
	  			System.out.println("Enter your choice::");
	  			    int choice = scan.nextInt();   

	  			switch(choice){
	  			case 1: 
	  					System.out.println("Enter Customer Name");
			  			 String cust_name=scan.next();
			  			System.out.println("Enter Customer Address");
			  			 String address=scan.next();
			  			System.out.println("Enter Customer Mobile Number");
			  			 String mobile=scan.next();
			  			 String cust_id="c"+(custList.size()+1);
			  			Customer_Details cust=new Customer_Details();
			  			cust.addCustomer(cust_id, cust_name, address, mobile);
			  			custList.add(cust);	
			  			System.out.println();
			  			System.out.println("Hi "+cust_name+", your customer id is "+cust_id);
			  			System.out.println("-----------------------------------------------------------");
			  			System.out.println();

			  	break;
	  			case 2: 
	  				System.out.println("Enter Customer ID");
		  			String custid=scan.next();
		  			if(getCustName(custid,custList).isEmpty()) {
		  				System.out.println("Sorry, no such Customer id available");
		  				System.out.println("-----------------------------------------------------------");
			  			System.out.println();
		  				break;
		  			}
		  			System.out.println("Enter Account Type (Savings/Loan)");
		  			String acct_type=scan.next();
		  			String acct_no="ACCT"+(acctList.size()+1);
		  			Account_Details acct=new Account_Details(acct_no, custid, acct_type, 0);
		  			
		  			acctList.add(acct);	
		  			System.out.println();
		  			System.out.println("Hi "+getCustName(custid,custList)+", your Account No is "+acct_no);
		  			System.out.println("-----------------------------------------------------------");
		  			System.out.println();
	  			//method call or logic for case 2
	  			break;
	  			case 3: System.out.println("Withdraw Money");
	  					System.out.println();
	  					System.out.println("Enter Account No");
			  			 String acctno=scan.next().toUpperCase();
			  			double bal=getBalance(acctno, custList, acctList);	
			  			System.out.println("Enter Amount to be withdrawn");
			  			double amt=scan.nextDouble();
			  			if(amt<=bal) {
			  				for(int i=0;i<acctList.size();i++) {
			  					if(acctList.get(i).getAccount_no().equals(acctno)) {
			  						acctList.get(i).setBalance(bal-amt);
			  					}
			  				}
			  				System.out.println("Successfully Withdrawn the money, your balance is "+(bal-amt));
			  			}
			  			else {
			  				System.out.println("You have insufficient amount to withdraw");
			  			}
			  			System.out.println("-----------------------------------------------------------");
			  			System.out.println();
	  			break;
	  			case 4: System.out.println("Deposit Money");
					System.out.println();
					System.out.println("Enter Account No");
					 acctno=scan.next().toUpperCase();
					System.out.println("Enter Amount to deposit");
					 amt=scan.nextDouble();
					bal=0;
	  				for(int i=0;i<acctList.size();i++) {
	  					if(acctList.get(i).getAccount_no().equals(acctno)) {
	  						bal=acctList.get(i).getBalance();
	  						acctList.get(i).setBalance(bal+amt);
	  					}
	  				}
	  				System.out.println("Successfully deposited the money, your balance is "+(bal+amt));
	  				System.out.println("-----------------------------------------------------------");
	  				System.out.println();
			break;
	  			case 5: System.out.println("List of Customer");
	  			System.out.println();
	  			for(int i=0;i<custList.size();i++) {
	  			
	  				System.out.println("Customer ID:"+custList.get(i).getCust_id()
	  						+" Customer Name:"+custList.get(i).getCust_name()
	  						+" Address:"+custList.get(i).getAddress()
	  						+" Mobile:"+custList.get(i).getMobile()
	  						);
	  				System.out.println("-----------------------------------------------------------");
		  			System.out.println();

	  			}
	  			break;
	  			case 6: System.out.println("List of Account");
	  			System.out.println();
	  			for(int i=0;i<acctList.size();i++) {
	  			
	  				System.out.println("Account number:"+acctList.get(i).getAccount_no()
	  						+" Customer Name:"+getCustName(acctList.get(i).getCust_id(),custList)
	  						+"Account Type:"+acctList.get(i).getAccount_type()
	  						+" Balance:"+acctList.get(i).getBalance()
	  						);
	  				System.out.println("-----------------------------------------------------------");
		  			System.out.println();

	  			}
	  			
	  			break;
	  			case 9: System.out.println("Exiting the application");
	  			System.exit(0);
	  			default: System.out.println("Enter valid choice");
	  			}
	  		}
	    
	}

}
