package reports;

import java.util.List;
import java.util.ArrayList;
import farmers.*;

public class RevenuePreviousMonth extends ManagerReport{
	
	private String start_date;
	private String end_date;
	private int orders_placed = 0;
	private int orders_delivered = 0;
	private int orders_open = 0;
	private int orders_cancelled = 0;
	private double total_revenue = 0.0;
	private double total_products_revenue = 0.0;
	private double total_delivery_revenue = 0.0;
	private final double lf2u_management_fee = 0.03;
	private double total_lftu_fees = 0.0;
	private double total_payable_to_farms = 0.0;
	private List<ManFarmerRevReport> mfrr;
	
	Finterface fi = new FarmerManager();
	
	public RevenuePreviousMonth(int mrid, String sd, String ed){
		super(mrid, "Revenue for last month");
		this.start_date = sd;
		this.end_date = ed;
		this.mfrr = new ArrayList<ManFarmerRevReport>();
		List<Farmer> flist = fi.viewAllFarmers();
		for(Farmer f: flist){
			int fint = f.getID();
			ManFarmerRevReport m = new ManFarmerRevReport(fint);
			mfrr.add(m);
		}
		for(ManFarmerRevReport x: mfrr){
			this.orders_placed += x.getOrdersPlaced();
			this.orders_delivered += x.getOrdersDelivered();
			this.orders_open += x.getOrdersOpen();
			this.orders_cancelled += x.getOrdersCancelled();
			this.total_revenue += x.getTotalRev();
			this.total_products_revenue += x.getProductsRev();
			this.total_delivery_revenue += x.getDeliveryRev();
			this.total_lftu_fees += x.getLf2uFees();
			this.total_payable_to_farms += x.getPayableToFarm();
		}
	}
}