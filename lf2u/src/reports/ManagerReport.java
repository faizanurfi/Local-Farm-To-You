package reports;

public class ManagerReport extends Report{
	private String name;
	private int mrid;
	
	public ManagerReport(int m, String n){
		this.name = n;
		this.mrid = m;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getMRID(){
		return this.mrid;
	}
}