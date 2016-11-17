package customers;

import order.Order;

import java.util.List;
import java.util.ArrayList;

public class Customer {
	private int id;
	private static int sid = 1;
	private String name;
	private String zip;
	private String address;
	private String phone;
	private String email;
	private List<Order>  olist;
	
	public Customer(){
		
	}
	
	public Customer(String n, String z, String a, String p, String e){
		this.name = n;
		this.zip = z;
		this.address = a;
		this.phone = p;
		this.email = e;
		id = sid;
		sid++;
		olist = new ArrayList<Order>();
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getZip(){
		return this.zip;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public List<Order> getOrderList(){
		return this.olist;
	}
	
	public void setID(int i){
		this.id = i;
	}
	
	public void setOrderList(List<Order> ol){
		this.olist = ol;
	}
}