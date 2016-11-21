package reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import farmers.*;
import order.*;

public class OrdersPlacedToday extends ManagerReport{
	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Calendar cal = Calendar.getInstance();
	Finterface fi = new FarmerManager();
	private int orders_placed = 0;
	private int orders_delivered = 0;
	private int orders_open = 0;
	private int orders_cancelled = 0;
	
	public OrdersPlacedToday(int mrid){
		super(mrid, "Orders placed today");
		cal.add(Calendar.DATE, 0);
		Date today = cal.getTime();
		String sd = df.format(today);
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