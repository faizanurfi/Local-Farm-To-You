package order;

public class Order {
	private int fid;
	private OrderDetail orderDetail;
	private String dNote = "";
	private int id;
	private static int sid = 1;
	private int cid;
	
	public Order(){}
	
	public Order(int f, OrderDetail od){
		this.fid = f;
		this.orderDetail = od;
		id = sid;
		sid++;
	}
	
	public Order(int f, OrderDetail od, String dn){
		this.fid = f;
		this.orderDetail = od;
		this.dNote = dn;
		id = sid;
		sid++;
	}
	
	public int getFID(){
		return this.fid;
	}
	
	public OrderDetail getOrderDetail(){
		return this.orderDetail;
	}
	
	public String getNote(){
		return this.dNote;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setFID(int f){
		this.fid = f;
	}
	
	public void setOrderDetail(OrderDetail od){
		this.orderDetail = od;
	}
	
	public void setNote(String dn){
		this.dNote = dn;
	}
	
	public void setID(int i){
		this.id = i;
	}
	
	public void setCID(int c){
		this.cid = c;
	}
}