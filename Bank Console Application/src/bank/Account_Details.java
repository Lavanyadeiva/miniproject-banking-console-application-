package bank;

public class Account_Details {

	String account_no,cust_id,account_type;
	double balance;
	
    public Account_Details(String acct_no,String custid,String acct_type,double balance) {
    	account_no=acct_no;
    	cust_id=custid;
    	account_type=acct_type;
    	this.balance=balance;   
    }
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    
}

