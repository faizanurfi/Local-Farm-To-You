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
	
	public Order [] viewOrders(int cid){
		Customer x = findByID(cid);
		List<Order> l = x.getOrderList();
		Order [] oa = (Order []) l.toArray();
		return oa;
	}//done

	public Order viewOrderByID(int cid, int oid) {
		Customer x = findByID(cid);
		List<Order> ol = x.getOrderList();
		Order r = findOrder(oid, ol);
		return r;
	}//done

	public String cancelOrder(int cid, int oid) {
		Customer x = findByID(cid);
		List<Order> ol = x.getOrderList();
		Order ox = new Order();
		for(Order o: ol){
			if(o.getID() == oid){
				o.setOpenStatus(false);
				ox = o;
				break;
			}
		}
		x.setOrderList(ol);
		setToID(cid, x); // Update Customer Order List
		
		Finterface fi = new FarmerManager();
		fi.setOrderToID(oid, ox); // Update Farmer order queue
		String status = "cancelled";
		return status;
	}//done
	
	public Customer findByID(int cid){
		Customer x = new Customer();
		for(Customer c: customers){
			if(c.getID() == cid){
				x = c;
				break;
			}
		}
		return x;
	}
	
	public void setToID(int cid, Customer x){
		for(Customer c: customers){
			if(c.getID() == cid){
				c = x;
				c.setID(cid);
				break;
			}
		}
	}
	
	public Order findOrder(int oid, List<Order> olist){
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
