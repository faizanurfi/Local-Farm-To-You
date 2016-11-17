package reports;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DeliverTodayReport extends FarmerReport{
	
	static DateFormat df = new SimpleDateFormat("yyyyMMdd");
	static Date dobj = new Date();
	static String sd = df.format(dobj);
	
	public DeliverTodayReport(String n){
		super(n, sd);
	}
}