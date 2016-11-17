package reports;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import farmers.*;
import order.*;

public class DeliverTodayReport extends FarmerReport{
	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Date today = Calendar.getInstance().getTime();
	String sd = df.format(today);
	private List<OrderReport> orlist;
	private Finterface fi = new FarmerManager();
	
	public DeliverTodayReport(int fid, int frid){
		super(frid, "Orders to deliver today");
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