package reports;

public class FarmerReport extends Report{
	final String name;
	final String deliveryDate;
	final int frid = 701;
	
	public FarmerReport(String n, String dd){
		this.name = n;
		this.deliveryDate = dd;
	}
}