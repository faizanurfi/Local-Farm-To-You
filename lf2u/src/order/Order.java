package order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import farmers.*;
import products.Product;

public class Order {
	private int fid;
	private int id;
	private static int sid = 1;
	String orderDate;
	String plannedDate = "";
	String deliveryDate = "";
	private boolean openStatus;
	private Farm farm_info;
	private List<Item> order_detail;
	private String dNote = "";
	private double products_total;
	private double delivery_charge;
	private double order_total;
	private boolean dStatus;
	private int cid;
	
	Finterface fi = new FarmerManager();
	
	public Order(){}
	
	public Order(int f){
		this.fid = f;
		this.order_detail = new ArrayList<Item>();
		this.id = sid;
		sid++;
		this.openStatus = true;
		this.dStatus = false;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dobj = new Date();
		String sd = df.format(dobj);
		this.orderDate = sd;
		
		for(Farmer far: fi.viewAllFarmers()){
			if(far.getID() == this.fid){
				this.farm_info = far.getFarm();
			}
		}
	}
	
	public Order(int f, String dn){
		this.fid = f;
		this.dNote = dn;
		this.order_detail = new ArrayList<Item>();
		this.id = sid;
		sid++;
		this.openStatus = true;
		this.dStatus = false;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dobj = new Date();
		String sd = df.format(dobj);
		this.orderDate = sd;
		
		for(Farmer far: fi.viewAllFarmers()){
			if(far.getID() == this.fid){
				this.farm_info = far.getFarm();
			}
		}
	}
	
	public int getFID(){
		return this.fid;
	}
	
	public String getNote(){
		return this.dNote;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int getCID(){
		return this.cid;
	}
	
	public List<Item> getItemList(){
		return this.order_detail;
	}
	
	public double getTotalPrice(){
		double tPrice = 0.0;
		for(Item i: order_detail){
			Finterface fi = new FarmerManager();
			Product p = fi.viewStoreProductDetail(this.fid, i.getFSPID());
			tPrice += getProductsPrice();
		}
		this.order_total = tPrice + fi.viewDeliveryCharge(fid);
		return this.order_total;
	}
	
	public double getProductsPrice(){
		double tPrice = 0.0;
		for(Item i: order_detail){
			i.calculateProductsPrice();
			tPrice += i.getTotalItemPrice();
		}
		this.products_total = tPrice;
		return this.products_total;
	}
	
	public String getDate(){
		return this.orderDate;
	}
	
	public String getPlannedDate(){
		return this.plannedDate;
	}
	
	public boolean getDeliveryStatus(){
		return this.dStatus;
	}
	
	public boolean getOpenStatus(){
		return this.openStatus;
	}
	
	public String getDeliveryDate(){
		return this.deliveryDate;
	}
	
	public void setFID(int f){
		this.fid = f;
	}
	
	public void setNote(String dn){
		this.dNote = dn;
	}
	
	public void setID(int i){
		this.id = i;
	}
	
	public void addItemToList(Item i){
		this.order_detail.add(i);
	}
	
	public void setCID(int c){
		this.cid = c;
	}
	
	public void setPlannedDate(String pd){
		this.plannedDate = pd;
	}
	
	public void setDeliveryStatus(boolean b){
		this.dStatus = b;
	}
	
	public void setOpenStatus(boolean b){
		this.openStatus = b;
	}
	
	public void setDeliveryDate(String d){
		this.deliveryDate = d;
	}
	
}