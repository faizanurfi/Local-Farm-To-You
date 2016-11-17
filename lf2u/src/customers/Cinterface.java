package customers;

import java.util.List;

import order.Order;

public interface Cinterface {
	void createAccount(Customer c);
	void updateAccount(int cid, Customer c);
	Customer viewAccount(int cid);
	void createOrder(int cid, Order o);
	List<Order> viewOrders(int cid);
	Order viewOrderByID(int cid, int oid);
	void cancelOrder(int cid, int oid);
	Customer findByID(int cid);
	void setToID(int cid, Customer c);
	Order findOrder(int oid, List<Order> ol);
	
	//List<Farmer> getFarmersThatDeliver();
	//List<Product> getFarmerProducts();
	//List<Product> getAvailDelivery();
	//List<Farmer> getFarmersByProduct();
}
