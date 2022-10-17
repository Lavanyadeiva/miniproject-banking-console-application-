package bank;

public class Customer_Details {
	
	String cust_id,cust_name,address,mobile;
	
	public void addCustomer(String custid,String name,String addr,String mobile) {
		cust_id=custid;
		cust_name=name;
		address=addr;
		this.mobile=mobile;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile(){
		return mobile;
	}

}
