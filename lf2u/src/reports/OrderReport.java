package reports;

import order.Order;
import farmers.*;
import customers.*;
import java.util.List;
import java.util.ArrayList;

public class OrderReport {
	private int fid;
	private Finterface fi = new FarmerManager();
	private int oid;
	private double products_total;
	private double delivery_charge;
	private double order_total;
	private String status;
	private String order_date;
	private String planned_delivery_date = "";
	private Cinterface ci = new CustomerManager();
	
	public OrderReport(int fid){
		List<Order> ol = fi.getOrderList(fid);
	}
}