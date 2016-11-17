package reports;

import order.*;
import farmers.*;
import customers.*;
import java.util.List;
import java.util.ArrayList;

public class OrderReport {
	private Finterface fi = new FarmerManager();
	private Cinterface ci = new CustomerManager();
	private int oid;
	private double products_total;
	private double delivery_charge;
	private double order_total;
	private String status;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date = "";
	private Customer ordered_by;
	private String delivery_address;
	private String note;
	private List<Item> order_detail;
	
	public OrderReport(Order o){
		oid = o.getID();
		this.products_total = o.getTotalPrice();
		this.delivery_charge = fi.viewDeliveryCharge(o.getFID());
		this.order_total = this.products_total + this.delivery_charge;
		if(o.getOpenStatus()){
			this.status = "open";
		}
		else {
			this.status = "closed";
		}
		this.order_date = o.getDate();
		this.planned_delivery_date = o.getPlannedDate();
		this.ordered_by = ci.findByID(o.getCID());
		this.delivery_address = ci.findByID(o.getCID()).getAddress();
		if(!(o.getNote().equals(""))){
			this.note = o.getNote();
		}
		this.order_detail = o.getItemList();
	}
}