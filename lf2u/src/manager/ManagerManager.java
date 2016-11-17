package manager;

import java.util.List;
import java.util.ArrayList;

import products.Product;
import reports.*;

public class ManagerManager implements Minterface {
	private static List<Manager> managers = new ArrayList<Manager>();

	public Product [] viewCatalog() {
		GeneralCatalog gc = new GeneralCatalog();
		List<Product> l = gc.getCatalogList();
		Product [] arr = new Product[l.size()];
		arr = l.toArray(arr);
		return arr;
	}//done

	public void addProductToCatalog(Product p) {
		GeneralCatalog gc = new GeneralCatalog();
		gc.addToCatalog(p);
	}//done

	public void updateCatalogProduct(int gcpid, Product p) {
		setProdToID(gcpid, p);
	}//done

	public List<Manager> viewAllManagers() {
		List<Manager> mlist = managers;
		return mlist;
	}//done

	public Manager viewAccount(int mid) {
		return findByID(mid);
	}//done

	public Report getReport() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Manager findByID(int mid){
		Manager x = new Manager();
		for(Manager m: managers){
			if(m.getID() == mid){
				x = m;
				break;
			}
		}
		return x;
	}
	
	private void setProdToID(int gcpid, Product p){
		GeneralCatalog gc = new GeneralCatalog();
		List<Product> gcl = gc.getCatalogList();
		for(Product x: gcl){
			if(x.getID() == gcpid){
				x = p;
				x.setID(gcpid);
				break;
			}
		}
	}
}