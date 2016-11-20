package manager;

import products.Product;
import reports.*;

import java.util.List;

import order.Order;

public interface Minterface {
	Product [] viewCatalog();
	Product getProductByID(int gcpid);
	void addProductToCatalog(Product p);
	void updateCatalogProduct(int gcpid, Product p);
	Manager[] viewAllManagers();
	Manager viewAccount(int mid);
	Report getReport(int mrid);
	Report getReportZip(int mrid, String zip);
	Report[] getAllReports();
	Order findOrder(int oid);
	void updateDeliveryOfOrderInList(boolean b, int oid);
	void addOrderToList(Order o);
	Order [] getAllOrders();
}