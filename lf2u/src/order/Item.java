package order;

import farmers.FarmerManager;
import farmers.Finterface;
import products.Product;

public class Item {
	private int fid;
	private int fspid;
	private double amount;
	private double iPrice;
	private double pPrice;
	
	public Item(int f, int fs, double a){
		this.fid = f;
		this.fspid = fs;
		this.amount = a;
	}
	
	public int getFID(){
		return this.fid;
	}
	
	public int getFSPID(){
		return this.fspid;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public double getPrice(){
		return this.iPrice;
	}
	
	public void setFID(int f){
		this.fid = f;
	}
	
	public void setFSPID(int f){
		this.fspid = f;
	}
	
	public void setAmount(double a){
		this.amount = a;
	}
	
	public void setPrice(double p){
		this.iPrice = p;
	}
	
	public void calculateItemPrice(){
		Finterface fi = new FarmerManager();
		Product p = fi.viewStoreProductDetail(this.fid, this.fspid);
		double total = p.getPrice()*amount + fi.viewDeliveryCharge(fid);
		this.setPrice(total);
	}
	
	public void calculateProductsPrice(){
		Finterface fi = new FarmerManager();
		Product p = fi.viewStoreProductDetail(this.fid, this.fspid);
		double total = p.getPrice()*amount;
		this.setPrice(total); 
	}
}