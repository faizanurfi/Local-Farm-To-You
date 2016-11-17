package reports;

public class RevenuePreviousMonth extends ManagerReport{
	
	private String start_date;
	private String end_date;
	private int orders_placed;
	private int orders_delivered;
	private int orders_open;
	private int orders_cancelled;
	private double total_revenue;
	private double total_products_revenue;
	private double total_delivery_revenue;
	private final double lf2u_management_fee = 0.03;
	private double total_lftu_fees;
	private double tota_payable_to_farms;
	
	public RevenuePreviousMonth(int mrid){
		super(mrid, "Revenue for last month");
	}
}