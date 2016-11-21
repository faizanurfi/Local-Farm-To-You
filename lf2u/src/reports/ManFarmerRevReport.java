package reports;

import farmers.*;
import customers.*;
import order.*;
import java.util.List;

public class ManFarmerRevReport {
	private int fid;
	private String name;
	private int orders_placed = 0;
	private int orders_delivered = 0;
	private int orders_open = 0;
	private int orders_cancelled = 0;
	private double total_revenue = 0.0;
	private double products_revenue = 0.0;
	private double delivery_revenue = 0.0;
	private double lf2u_fees = 0.0;
	private double payable_to_farm;
	
	Finterface fi = new FarmerManager();
	Cinterface ci = new CustomerManager();
	
	public ManFarmerRevReport(int f, String sd, String ed){
		this.fid = f;
		Farmer x = fi.findByID(this.fid);
		this.name = x.getName();
		List<Order> ol = x.getOrderList();
		for (Order o: ol){
			int od = Integer.parseInt(o.getDate());
			int sdi = Integer.parseInt(sd);
			int edi = Integer.parseInt(ed);
			if(od >= sdi && od <= edi){
				orders_placed++;
				if(o.getDeliveryStatus()){
					orders_delivered++;
					total_revenue += o.getTotalPrice();
					products_revenue += o.getProductsPrice();
					delivery_revenue += x.getDeliveryCharge();
					lf2u_fees = 0.03*total_revenue;
					payable_to_farm = total_revenue - lf2u_fees;
				}
				if(o.getOpenStatus()){
					orders_open++;
				}
				if(o.getOpenStatus() == false && o.getDeliveryStatus() == false){
					orders_cancelled++;
				}
			}
		}
	}
	
	public ManFarmerRevReport(int f, String d){
		this.fid = f;
		Farmer x = fi.findByID(this.fid);
		this.name = x.getName();
		List<Order> ol = x.getOrderList();
		for (Order o: ol){
			String date = o.getDeliveryDate();
			if(date.equals(d)){
				orders_placed++;
				if(o.getDeliveryStatus()){
					orders_delivered++;
					total_revenue += o.getTotalPrice();
					products_revenue += o.getProductsPrice();
					delivery_revenue += x.getDeliveryCharge();
					lf2u_fees = 0.03*total_revenue;
					payable_to_farm = total_revenue - lf2u_fees;
				}
				if(o.getOpenStatus()){
					orders_open++;
				}
				if(o.getOpenStatus() == false && o.getDeliveryStatus() == false){
					orders_cancelled++;
				}
			}
		}
	}
	
	public ManFarmerRevReport(int f, String d, String z, String z1){
		this.fid = f;
		Farmer x = fi.findByID(this.fid);
		this.name = x.getName();
		List<Order> ol = x.getOrderList();
		for (Order o: ol){
			String date = o.getDeliveryDate();
			String zip = ci.findByID(o.getCID()).getZip();
			if(date.equals(d) && zip.equals(z)){
				orders_placed++;
				if(o.getDeliveryStatus()){
					orders_delivered++;
					total_revenue += o.getTotalPrice();
					products_revenue += o.getProductsPrice();
					delivery_revenue += x.getDeliveryCharge();
					lf2u_fees = 0.03*total_revenue;
					payable_to_farm = total_revenue - lf2u_fees;
				}
				if(o.getOpenStatus()){
					orders_open++;
				}
				if(o.getOpenStatus() == false && o.getDeliveryStatus() == false){
					orders_cancelled++;
				}
			}
		}
	}
	
	public int getOrdersPlaced(){
		return this.orders_placed;
	}
	
	public int getOrdersDelivered(){
		return this.orders_delivered;
	}
	
	public int getOrdersOpen(){
		return this.orders_open;
	}
	
	public int getOrdersCancelled(){
		return this.orders_cancelled;
	}
	
	public double getTotalRev(){
		return this.total_revenue;
	}
	
	public double getProductsRev(){
		return this.products_revenue;
	}
	
	public double getDeliveryRev(){
		return this.delivery_revenue;
	}
	
	public double getLf2uFees(){
		return this.lf2u_fees;
	}
	
	public double getPayableToFarm(){
		return this.payable_to_farm;
	}
}
