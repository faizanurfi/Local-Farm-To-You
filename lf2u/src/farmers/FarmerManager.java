package farmers;

import java.util.ArrayList;


import java.util.List;

import products.Product;
import customers.Customer;
import manager.FarmerCatalog;
import manager.Catalog;
import order.Order;

public class FarmerManager implements Finterface {
	private static List<Farmer> farmers = new ArrayList<Farmer>();
	
	public void createAccount(Farmer f) {
		Farmer x = f;
		farmers.add(x);
	}//done

	public void updateAccount(int fid, Farmer f) {
		setToID(fid, f);
	}//done

	public Farmer viewAccount(int fid) {
		Farmer x = findByID(fid);
		return x;
	}//done

	public List<Farmer> viewFarmers(String zip) {
		List<Farmer> newFList = farmers;
		return newFList;
	}//done

	public double viewDeliveryCharge(int fid) {
		Farmer x = findByID(fid);
		double rtd = x.getDeliveryCharge();
		return rtd;
	}//done

	public void updateDeliveryCharge(int fid, double dc) {
		Farmer x = findByID(fid);
		x.setDeliveryCharge(dc);
		setToID(fid, x);
	}//done

	public Catalog viewFarmStore(int fid) {
		Farmer x = findByID(fid);
		Catalog fc = x.getFarmerCatalog();
		return fc;
	}//done

	public void addProductToStore(int fid, Product p) {
		Farmer x = findByID(fid);
		x.getFarmerCatalog().addToCatalog(p);
		setToID(fid, x);
	}//done

	public void modifyStoreProduct(int fid, int fspid, Product p) {
		Farmer x = findByID(fid);
		x.getFarmerCatalog().setProdToID(fspid, p);
	}//unimplemented: needs modification to take a particular parameter and updating it only

	public Product viewStoreProductDetail(int fid, int fspid) {
		Farmer x = findByID(fid);
		Product p = x.getFarmerCatalog().findProduct(fspid);
		return p;
	}//done
	
	public void addOrderToList(Order o){
		findByID(o.getFID()).getOrderList().add(o);
	}
	
	public List<Order> getOrderList(int fid){
		List<Order> rl = findByID(fid).getOrderList();
		return rl;
	}	
	public Report getReport(int fid) {
		return null;
	}
	

	public Farmer findByID(int fid){
		Farmer x = new Farmer();
		for(Farmer f: farmers){
			if(f.getID() == fid){
				x = f;
				break;
			}
		}
		return x;
	}
	
	public void setToID(int fid, Farmer x){
		for(Farmer f: farmers){
			if(f.getID() == fid){
				f = x;
				f.setID(fid);
				break;
			}
		}
	}
}