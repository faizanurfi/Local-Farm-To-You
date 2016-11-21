package reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import farmers.Farmer;
import farmers.FarmerManager;
import farmers.Finterface;
import order.Order;

public class OrdersPlacedYesterday extends ManagerReport{
	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Calendar cal = Calendar.getInstance();
	Finterface fi = new FarmerManager();
	private int orders_placed = 0;
	private int orders_delivered = 0;
	private int orders_open = 0;
	private int orders_cancelled = 0;
	
	public OrdersPlacedYesterday(int mrid){
		super(mrid, "Orders placed yesterday");
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		String sd = df.format(yesterday);
		for(Farmer f: fi.viewAllFarmers()){
			for(Order o: fi.getOrderList(f.getID())){
				if(o.getDate().equals(sd)){
					orders_placed++;
					if(o.getDeliveryStatus()){
						orders_delivered++;
					}
					if(o.getOpenStatus()){
						orders_open++;
					}
					if(o.getDeliveryStatus() == false && o.getOpenStatus() ==false){
						orders_cancelled++;
					}
				}
			}
		}
	}
}