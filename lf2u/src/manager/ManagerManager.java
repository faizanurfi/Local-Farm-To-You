package manager;

import java.util.List;
import java.util.ArrayList;

import products.Product;
import reports.*;

public class ManagerManager implements Minterface {
	private static List<Manager> managers = new ArrayList<Manager>();
	private ManagerReport mr1 = new ManagerReport(1, "orders placed today");
	private ManagerReport mr2 = new ManagerReport(2, "orders placed yesterday");
	private ManagerReport mr3 = new ManagerReport(3, "Revenue for previous month");
	private ManagerReport mr4 = new ManagerReport(4, "Revenue yesterday");
	private ManagerReport mr5 = new ManagerReport(1, "Revenue yesterday by zip code");
	private ManagerReport [] mra = {mr1, mr2, mr3, mr4, mr5};

	public Product [] viewCatalog() {
		GeneralCatalog gc = new GeneralCatalog();
		List<Product> l = gc.getCatalogList();
		Product [] arr = new Product[l.size()];
		arr = l.toArray(arr);
		return arr;
	}//done
	
	public Product getProductByID(int gcpid){
		GeneralCatalog gc = new GeneralCatalog();
		Product p = new Product();
		for(Product x: gc.getCatalogList()){
			if(x.getGCPID() == gcpid){
				p = x;
				break;
			}
		}
		return p;
	}//done

	public void addProductToCatalog(Product p) {
		GeneralCatalog gc = new GeneralCatalog();
		gc.addToCatalog(p);
	}//done

	public void updateCatalogProduct(int gcpid, Product p) {
		setProdToID(gcpid, p);
	}//done

	public Manager[] viewAllManagers() {
		List<Manager> mlist = managers;
		Manager [] marr = (Manager[]) mlist.toArray();
		return marr;
	}//done

	public Manager viewAccount(int mid) {
		return findByID(mid);
	}//done

	public Report getReportZip(int mrid, String zip) {
		Report r = new Report();
		if(mrid == 5){
			ManagerReport mr = new RevenueYesterdayZip(mrid, zip);
			r = mr;
		}
		return r;
	}//done
	
	public Report getReport(int mrid){
		Report r = new Report();
		if(mrid == 1){
			ManagerReport mr = new OrdersPlacedToday(mrid);
			r = mr;
		}
		else if(mrid == 2){
			ManagerReport mr = new OrdersPlacedYesterday(mrid);
			r = mr;
		}
		else if(mrid == 3){
			ManagerReport mr = new RevenuePreviousMonth(mrid);
			r = mr;
		}
		else if(mrid == 4){
			ManagerReport mr = new RevenueYesterday(mrid);
			r = mr;
		}
		return r;
	}//done
	
	public ManagerReport[] getAllReports(){
		return this.mra;
	}//done
	
	private Manager findByID(int mid){
		Manager x = new Manager();
		for(Manager m: managers){
			if(m.getID() == mid){
				x = m;
				break;
			}
		}
		return x;
	}
	
	private void setProdToID(int gcpid, Product p){
		GeneralCatalog gc = new GeneralCatalog();
		List<Product> gcl = gc.getCatalogList();
		for(Product x: gcl){
			if(x.getGCPID() == gcpid){
				x = p;
				x.setGCPID(gcpid);
				break;
			}
		}
	}
}