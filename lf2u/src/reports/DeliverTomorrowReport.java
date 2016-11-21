package reports;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.util.List;

import farmers.FarmerManager;
import farmers.Finterface;
import order.Order;

public class DeliverTomorrowReport extends FarmerReport{
	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Calendar cal = Calendar.getInstance();
	private List<OrderReport> orlist;
	private Finterface fi = new FarmerManager();
	
	public DeliverTomorrowReport(int fid, int frid){		
		super(frid, "Orders to deliver tomorrow");
		cal.add(Calendar.DATE, 1);
		Date tomorrow = cal.getTime();
		String sd = df.format(tomorrow);
		orlist = new ArrayList<OrderReport>();
		List<Order> ol = fi.getOrderList(fid);
		for(Order o: ol){
			if(o.getPlannedDate().equals(sd)){
				OrderReport or = new OrderReport(o);
				orlist.add(or);
			}
		}
	}
}