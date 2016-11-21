package reports;

import farmers.*;
import order.*;
import java.util.List;

public class FarmerRevenueReport extends FarmerReport{
	
	Finterface fi = new FarmerManager();
	
	private String start_date;
	private String end_date;
	private int f;
	private int orders_placed = 0;
	private int orders_cancelled = 0;
	private int orders_delivered = 0;
	private double products_revenue = 0.0;
	private double delivery_revenue = 0.0;
	
	public FarmerRevenueReport(int fid, int frid, String sd, String ed){
		super(frid, "Revenue Report");
		this.start_date = sd;
		this.end_date = ed;
		this.f = fid;
		List<Order> ol = fi.getOrderList(fid);
		for(Order o: ol){
			int oi = Integer.parseInt(o.getDate());
			int sdi = Integer.parseInt(this.start_date);
			int edi = Integer.parseInt(this.end_date);
			if(oi >= sdi && oi <= edi){
				this.orders_placed++;
				if(o.getOpenStatus() == false){
					this.orders_cancelled++;
				}
				if(o.getDeliveryStatus() == true){
					this.orders_delivered++;
					this.products_revenue += o.getProductsPrice();
					this.delivery_revenue += fi.viewDeliveryCharge(fid);
				}
			}
		}
	}
}