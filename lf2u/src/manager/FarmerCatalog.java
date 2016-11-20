package manager;

import products.Product;

import java.util.List;
import java.util.ArrayList;

//Modified by Mangers and Farmers. Viewed by Everyone
public class FarmerCatalog extends Catalog {
	protected List<Product> fcat;
	
	public FarmerCatalog(){
		fcat = new ArrayList<Product>();
	}

	public void addToCatalog(Product x) {
		fcat.add(x);
	}
	
	public List<Product> getCatalogList(){
		return fcat;
	}
	
	public Product findProduct(int fspid){
		Product p = new Product();
		for(Product x: fcat){
			if(p.getFSPID() == fspid){
				p = x;
				break;
			}
		}
		return p;
	}
	
	public void setProdToID(int fspid, Product p){
		for(Product x: fcat){
			if(x.getFSPID() == fspid){
				x = p;
				break;
			}
		}
	}
}