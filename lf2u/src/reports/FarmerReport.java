package reports;

public class FarmerReport extends Report{
	final String name;
	private int frid;
	
	public FarmerReport(int f, String n){
		this.name = n;
		this.frid = f;
	}
}