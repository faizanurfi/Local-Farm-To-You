package reports;

public class FarmerReport extends Report{
	private String name;
	private int frid;
	
	public FarmerReport(int f, String n){
		this.name = n;
		this.frid = f;
	}
	public FarmerReport(){}
	
	public String getName(){
		return this.name;
	}
	
	public int getFRID(){
		return this.frid;
	}
}