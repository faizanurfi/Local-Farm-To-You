package farmers;

import products.Product;
import manager.FarmerCatalog;
import manager.Catalog;
import order.Order;

import java.util.List;

public interface Finterface {
	void createAccount(Farmer f);
	void updateAccount(int fid, Farmer f);
	Farmer viewAccount(int fid);
	List<Farmer> viewFarmers(String zip);
	Catalog viewFarmStore(int fid);
	void addProductToStore(int fid, Product p);
	void modifyStoreProduct(int fid, int fspid, Product p);
	Product viewStoreProductDetail(int fid, int fspid);
	void addOrderToList(Order o);
	List<Order> getOrderList(int fid);
	Report getReport(int fid);
	double viewDeliveryCharge(int fid);
	void updateDeliveryCharge(int fid, double dc);
}
