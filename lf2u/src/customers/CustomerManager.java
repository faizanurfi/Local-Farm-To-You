package customers;

import java.util.List;


import java.util.ArrayList;
import order.Order;
import farmers.FarmerManager;
import farmers.Finterface;

public class CustomerManager implements Cinterface {
	private static List<Customer> customers = new ArrayList<Customer>();
	
	public void createAccount(Customer c) {
		Customer x = c;
		customers.add(x);
	}//done

	public void updateAccount(int cid, Customer c) {
		setToID(cid, c);
	}//done

	public Customer viewAccount(int cid) {
		Customer x = findByID(cid);
		return x;
	}//done
	
	public void createOrder(int cid, Order o) {
		o.setCID(cid);
		findByID(cid).getOrderList().add(o);
		Finterface fi = new FarmerManager();
		fi.addOrderToList(o);
	}//done
	
	public List<Order> viewOrders(int cid){
		Customer x = findByID(cid);
		return x.getOrderList();
	}//done

	public Order viewOrderByID(int cid, int oid) {
		Customer x = findByID(cid);
		List<Order> ol = x.getOrderList();
		Order r = findOrder(oid, ol);
		return r;
	}//done

	public void cancelOrder(int cid, int oid) {
		Customer x = findByID(cid);
		List<Order> ol = x.getOrderList();
		int index = 0;
		for(Order o: ol){
			if(o.getID() == oid){
				ol.remove(index);
				break;
			}
			index++;
		}
		x.setOrderList(ol);
		setToID(cid, x);
	}//done
	
	private Customer findByID(int cid){
		Customer x = new Customer();
		for(Customer c: customers){
			if(c.getID() == cid){
				x = c;
				break;
			}
		}
		return x;
	}
	
	private void setToID(int cid, Customer x){
		for(Customer c: customers){
			if(c.getID() == cid){
				c = x;
				c.setID(cid);
				break;
			}
		}
	}
	
	private Order findOrder(int oid, List<Order> olist){
		Order x = new Order();
		for(Order o: olist){
			if(o.getID() == oid){
				x = o;
				break;
			}
		}
		return x;
	}
}
