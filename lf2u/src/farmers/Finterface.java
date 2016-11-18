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
	List<Farmer> viewFarmers(String zip);
	List<Farmer> viewAllFarmers();
	Catalog viewFarmStore(int fid);
	void addProductToStore(int fid, Product p);
	void modifyStoreProduct(int fid, int fspid, Product p);
	Product viewStoreProductDetail(int fid, int fspid);
	void addOrderToList(Order o);
	List<Order> getOrderList(int fid);
	Report getReport(int fid, int frid, String sd, String ed);
	Report [] getAllReports();
	double viewDeliveryCharge(int fid);
	void updateDeliveryCharge(int fid, double dc);
	Farmer findByID(int fid);
	void setToID(int fid, Farmer x);
	void setOrderToID(int oid, Order o);
}
