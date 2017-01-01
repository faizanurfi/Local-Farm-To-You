package manager;

import java.util.List;

import order.Order;

import java.util.ArrayList;

import products.Product;
import reports.*;

public class ManagerManager implements Minterface {
	private static List<Manager> managers = new ArrayList<Manager>();
	private ManagerReport mr1 = new ManagerReport(1, "orders placed today");
	private ManagerReport mr2 = new ManagerReport(2, "orders placed yesterday");
	private ManagerReport mr3 = new ManagerReport(3, "Revenue for previous month");
	private ManagerReport mr4 = new ManagerReport(4, "Revenue yesterday");
	private ManagerReport mr5 = new ManagerReport(5, "Revenue yesterday by zip code");
	private ManagerReport [] mra = {mr1, mr2, mr3, mr4, mr5};
	private static List<Order> orders = new ArrayList<Order>();
	private Manager man1;
	private Manager man2;
	
	
	public ManagerManager(){
		managers.clear();
		Manager.sid = 1;
		man1 = new Manager("Super User", "System", "20161116", "123-0987-659", "super.user@example.com");
		managers.add(man1);
	}
		
	public void addManagers(){
		//managers.add(man1);
		//managers.add(man2);
	}
	
	public Product [] viewCatalog() {
		GeneralCatalog gc = new GeneralCatalog();
		List<Product> l = gc.getCatalogList();
		Product [] arr = new Product[l.size()];
		arr = l.toArray(arr);
		return (arr);
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
		return (p);
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
		Manager [] marr = mlist.toArray(new Manager[mlist.size()]);
		return (marr);
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
		return (r);
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
		return (r);
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
		return (x);
	}
	
	private void setProdToID(int gcpid, Product p){
		GeneralCatalog gc = new GeneralCatalog();
		int i = 0;
		for(Product x: gc.getCatalogList()){
			if(x.getGCPID() == gcpid){
				p.setGCPID(gcpid);
				gc.getCatalogList().remove(i);
				gc.getCatalogList().add(i, p);
				break;
			}
			i++;
		}
	}
	
	public Order findOrder(int oid){
		Order x = new Order();
		for(Order o: orders){
			if(o.getID() == oid){
				x = o;
				break;
			}
		}
		return (x);
	}
	
	public void updateDeliveryOfOrderInList(boolean b, int oid){
		for(Order o: orders){
			if(o.getID() == oid){
				o.setDeliveryStatus(b);
				break;
			}
		}
	}
	
	public void addOrderToList(Order o){
		orders.add(o);
	}
	
	public Order[] getAllOrders(){
		Order[] oarr = (Order[]) orders.toArray();
		return (oarr);
	}
}
