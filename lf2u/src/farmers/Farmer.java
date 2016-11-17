package farmers;
//encapsulation: accessor methods to protected. Only classes in package can see (FarmerManager)

import manager.FarmerCatalog;
import java.util.List;
import java.util.ArrayList;
import order.Order;

public class Farmer {
	private int id;
	private static int sid = 1;
	private String name;
	private String phone;
	private String email;
	private Farm farm;
	private double dCharge = 0.0;
	private FarmerCatalog fCat;
	private List<Order> fol;
	
	public Farmer(){
		
	}
	
	public Farmer(String n, String p, String e, Farm f){
		this.name = n;
		this.phone = p;
		this.email = e;
		this.farm = f;
		fCat = new FarmerCatalog();
		fol = new ArrayList<Order>();
		id = sid;
		sid++;
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public Farm getFarm(){
		return this.farm;
	}
	
	public FarmerCatalog getFarmerCatalog(){
		return this.fCat;
	}
	
	public double getDeliveryCharge(){
		return this.dCharge;
	}
	
	public List<Order> getOrderList(){
		return this.fol;
	}
	
	public void setDeliveryCharge(double dc){
		this.dCharge = dc;
	}
	
	public void setID(int i){
		this.id = i;
	}
}