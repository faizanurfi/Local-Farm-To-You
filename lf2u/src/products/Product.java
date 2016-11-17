package products;

import manager.Catalog.catalogProduct;

public class Product {
	public enum unit{OUNCE, POUND, PINT, GALLON}
	private String name;
	private catalogProduct productType;
	private double price;
	private unit unitOfPrice;
	private int id;
	private static int sid = 1;
	
	public Product(){}
	
	public Product(String n, catalogProduct pt, double p, unit up){
		this.name = n;
		this.productType = pt;
		this.price = p;
		this.unitOfPrice = up;
		id = sid;
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
	
	public int getID(){
		return this.id;
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
	
	public void setID(int i){
		this.id = i;
	}
}