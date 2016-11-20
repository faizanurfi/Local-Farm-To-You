package products;

import manager.Catalog.catalogProduct;

public class Product {
	public enum unit{OZ, LB, PINT, GAL}
	private String name;
	private catalogProduct productType;
	private String start_date = "";
	private String end_date = ""; 
	private double price;
	private unit unitOfPrice;
	private String note = "";
	private String img = "";
	
	private int id;
	private static int sid = 1;
	
	private int fsid;
	private static int fssid = 1;
	
	public Product(){}
	
	public Product(String n){
		this.name = n;
		this.id = sid;
		sid++;
	}
	
	public Product(String n, catalogProduct pt, double p, unit up){
		this.name = n;
		this.productType = pt;
		this.price = p;
		this.unitOfPrice = up;
		this.id = sid;
		sid++;
	}
	
	public String getName(){
		return this.name;
	}
	
	public catalogProduct getProductType(){
		return this.productType;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public unit getUnitOfPrice(){
		return this.unitOfPrice;
	}
	
	public int getGCPID(){
		return this.id;
	}
	
	public String getSD(){
		return this.start_date;
	}
	
	public String getED(){
		return this.end_date;
	}
	
	public String getNote(){
		return this.note;
	}
	
	public String getImg(){
		return this.img;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setProductType(catalogProduct cp){
		this.productType = cp;
	}
	
	public void setPrice(double p){
		this.price = p;
	}
	
	public void setUnitOfPrice(unit u){
		this.unitOfPrice = u;
	}
	
	public void setGCPID(int i){
		this.id = i;
	}
	
	public void setSD(String sd){
		this.start_date = sd;
	}
	
	public void setED(String ed){
		this.end_date = ed;
	}
	
	public void setNode(String n){
		this.note = n;
	}
	
	public void setImg(String i){
		this.img = i;
	}
	
	public void setFSPID(){
		this.fsid = this.fssid;
		this.fssid++;
	}
	
	public int getFSPID(){
		return this.fsid;
	}
}