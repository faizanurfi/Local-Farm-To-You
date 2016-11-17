package order;

public class OrderDetail {
	private int fspid;
	private double amount;
	
	public OrderDetail(int f, double a){
		this.fspid = f;
		this.amount = a;
	}
	
	public int getFSPID(){
		return this.fspid;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public void setFSPID(int f){
		this.fspid = f;
	}
	
	public void setAmount(double a){
		this.amount = a;
	}
}