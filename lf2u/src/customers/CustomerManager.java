package customers;

import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import order.*;
import manager.ManagerManager;
import manager.Minterface;
import farmers.*;

public class CustomerManager implements Cinterface {
	private static List<Customer> customers = new ArrayList<Customer>();
	Minterface mi = new ManagerManager();
	Finterface fi = new FarmerManager();
	
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
	
	public Order findOrder(int oid, List<Order> ol){
		Order x = new Order();
		for(Order o: ol){
			if(o.getID() == oid){
				x = o;
				break;
			}
		}
		return x;
	}
	
	public Customer searchC(String k){
		Customer c = new Customer();
		for(Customer co: customers){
			String s = ""+co.getID();
			if(k.equals(s)){
				c = co;
				break;
			}
			s = co.getName();
			StringTokenizer strtok = new StringTokenizer(s, " ");
			String s1 = strtok.nextToken();
			String s2 = strtok.nextToken();
			if(k.equals(s1) || k.equals(s2)){
				c = co;
				break;
			}
			s = co.getAddress();
			if(k.equals(s)){
				c = co;
				break;
			}
			s = co.getZip();
			if(k.equals(s)){
				c = co;
				break;
			}
			s = co.getPhone();
			if(k.equals(s)){
				c = co;
				break;
			}
			s = co.getEmail();
			if(k.equals(s)){
				c = co;
				break;
			}
		}
		return c;
	}
	
	public Customer [] searchCWO(){
		Customer [] carr = (Customer[])customers.toArray();
		return carr;
	}
	
	public Order searchO(String k){
		Order o = new Order();
		for(Order oo: mi.getAllOrders()){
			boolean b = false;
			String s = ""+oo.getID();
			if(k.equals(s)){
				o = oo;
				break;
			}
			s = oo.getDate();
			if(k.equals(s)){
				o = oo;
				break;
			}
			s = oo.getPlannedDate();
			if(k.equals(s)){
				o = oo;
				break;
			}
			s = oo.getDeliveryDate();
			if(k.equals(s)){
				o = oo;
				break;
			}
			if(oo.getOpenStatus()){
				s = "open";
			}
			else if(oo.getOpenStatus() == false){
				s = "closed";
			}
			if(k.equals(s)){
				o = oo;
				break;
			}
			if(this.searchCFO(k, oo.getCID())){
				o = oo;
				break;
			}
			if(this.searchFFO(k, oo.getFID())){
				o = oo;
				break;
			}
			List<Item> il = oo.getItemList();
			for(Item i: il){
				s = ""+i.getFSPID();
				if(k.equals(s)){
					o = oo;
					b = true;
					break;
				}
				s = ""+i.getAmount();
				if(k.equals(s)){
					o = oo;
					b = true;
					break;
				}
				s = ""+i.getPrice();
				if(k.equals(s)){
					o = oo;
					b = true;
					break;
				}
				s = ""+i.getTotalItemPrice();
				if(k.equals(s)){
					o = oo;
					b = true;
					break;
				}
			}
			if(b){
				break;
			}
			s = oo.getNote();
			if(k.equals(s)){
				o = oo;
				break;
			}
			s = ""+oo.getProductsPrice();
			if(k.equals(s)){
				o = oo;
				break;
			}
			s = ""+oo.getTotalPrice();
			if(k.equals(s)){
				o = oo;
				break;
			}
			Farmer f = fi.findByID(oo.getFID());
			s = ""+f.getDeliveryCharge();
			if(k.equals(s)){
				o = oo;
				break;
			}
		}
		return o;
	}
	
	public Order [] searchOWO(){
		return mi.getAllOrders();
	}
	
	private boolean searchCFO(String k, int cid){
		Customer co = this.findByID(cid);
		boolean b = false;
		String s = ""+co.getID();
		if(k.equals(s)){
			b = true;
		}
		s = co.getName();
		StringTokenizer strtok = new StringTokenizer(s, " ");
		String s1 = strtok.nextToken();
		String s2 = strtok.nextToken();
		if(k.equals(s1) || k.equals(s2)){
			b = true;
		}
		s = co.getAddress();
		if(k.equals(s)){
			b = true;
		}
		s = co.getZip();
		if(k.equals(s)){
			b = true;
		}
		s = co.getPhone();
		if(k.equals(s)){
			b = true;
		}
		s = co.getEmail();
		if(k.equals(s)){
			b = true;
		}
		
		return b;
	}
	
	private boolean searchFFO(String k, int fid){
		Farmer fo = fi.findByID(fid);
		Farm fa = fo.getFarm();
		boolean b = false;
		String s = ""+fo.getID();
		if(k.equals(s)){
			b = true;
		}
		s = fa.getName();
		StringTokenizer strtok = new StringTokenizer(s, " ");
		String s1 = strtok.nextToken();
		String s2 = strtok.nextToken();
		if(k.equals(s1) || k.equals(s2)){
			b = true;
		}
		s = fa.getAddress();
		if(k.equals(s)){
			b = true;
		}
		s = fa.getPhone();
		if(k.equals(s)){
			b = true;
		}
		s = fa.getWebsite();
		if(k.equals(s)){
			b = true;
		}
		
		return b;
	}
}
