package order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order {
	private int fid;
	private String dNote = "";
	private int id;
	private static int sid = 1;
	String orderDate;
	String plannedDate;
	private int cid;
	private double productPrice;
	private double totalPrice;
	private List<Item> items;
	private boolean openStatus;
	private boolean dStatus;
	
	public Order(){}
	
	public Order(int f){
		this.fid = f;
		this.items = new ArrayList<Item>();
		this.id = sid;
		sid++;
		this.openStatus = true;
		this.dStatus = false;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dobj = new Date();
		String sd = df.format(dobj);
		this.orderDate = sd;
	}
	
	public Order(int f, String dn){
		this.fid = f;
		this.dNote = dn;
		this.items = new ArrayList<Item>();
		this.id = sid;
		sid++;
		this.openStatus = true;
		this.dStatus = false;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dobj = new Date();
		String sd = df.format(dobj);
		this.orderDate = sd;
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
		return this.items;
	}
	
	public double getTotalPrice(){
		double tPrice = 0.0;
		for(Item i: items){
			i.calculateItemPrice();
			tPrice += i.getPrice();
		}
		this.totalPrice = tPrice;
		return this.totalPrice;
	}
	
	public double getProductPrice(){
		double tPrice = 0.0;
		for(Item i: items){
			i.calculateProductsPrice();
			tPrice += i.getPrice();
		}
		this.productPrice = tPrice;
		return this.productPrice;
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
		this.items.add(i);
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
}