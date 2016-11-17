package farmers;
//encapsulation: accessor methods to protected. Only classes in package can see (FarmerManager)

import manager.FarmerCatalog;
import java.util.List;
import java.util.ArrayList;
import order.Order;
import reports.*;

public class Farmer {
	private int id;
	private static int sid = 1;
	private String name;
	private String phone;
	private String email;
	private Farm farm;
	private double dCharge = 0.0;
	private FarmerCatalog fCat; // each farmer has a farmer catalog/farmer store
	private List<Order> fol; // each farmer has a list of orders
	private List<FarmerReport> frl; // each farmer has a list of reports
	
	public Farmer(){
		
	}
	
	public Farmer(String n, String p, String e, Farm f){
		this.name = n;
		this.phone = p;
		this.email = e;
		this.farm = f;
		this.fCat = new FarmerCatalog();
		this.fol = new ArrayList<Order>();
		this.frl = new ArrayList<FarmerReport>();
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
	
	public List<FarmerReport> getFarmerReportList(){
		return this.frl;
	}
	
	public void setDeliveryCharge(double dc){
		this.dCharge = dc;
	}
	
	public void setID(int i){
		this.id = i;
	}
}