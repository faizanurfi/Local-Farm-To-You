package farmers;

import products.Product;
import manager.Catalog;
import order.Order;
import reports.*;

import java.util.List;

public interface Finterface {
	void createAccount(Farmer f);
	void updateAccount(int fid, Farmer f);
	Farmer viewAccount(int fid);
	Farmer[] viewFarmers(String zip);
	Farmer[] viewAllFarmers();
	Catalog viewFarmStore(int fid);
	void addProductToStore(int fid, Product p);
	Product viewStoreProductDetail(int fid, int fspid);
	Product getProductByID(int gcpid);
	void addOrderToList(Order o);
	List<Order> getOrderList(int fid);
	FarmerReport getReport(int fid, int frid, String sd, String ed);
	Report getReport(int fid, int frid);
	Report [] getAllReports();
	double viewDeliveryCharge(int fid);
	void updateDeliveryCharge(int fid, double dc);
	Farmer findByID(int fid);
	void setToID(int fid, Farmer x);
	void setOrderToID(int oid, Order o);
	void setProductToID(int fid, int fspid, Product p);
	Farm [] getFarmList();
	void addToFarmList(Farm f);
	Farmer search(String k);
	Farm[] searchFWO();
}
