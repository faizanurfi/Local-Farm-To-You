package reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import farmers.FarmerManager;
import farmers.Finterface;
import order.Order;

public class DeliverTomorrowReport extends FarmerReport{
	static DateFormat df = new SimpleDateFormat("yyyyMMdd");
	static Date dobj = new Date();
	static Date tomorrow = new Date(dobj.getTime() + (1000 * 60 * 60 * 24));
	static String sd = df.format(tomorrow);
	private List<OrderReport> orlist;
	private Finterface fi = new FarmerManager();
	
	public DeliverTomorrowReport(int fid, int frid){
		super(frid, "Orders to deliver tomorrow");
		orlist = new ArrayList<OrderReport>();
		List<Order> ol = fi.getOrderList(fid);
		for(Order o: ol){
			if(o.getPlannedDate() == sd){
				OrderReport or = new OrderReport(o);
				orlist.add(or);
			}
		}
	}
}
