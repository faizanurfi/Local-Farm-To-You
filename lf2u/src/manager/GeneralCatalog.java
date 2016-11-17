package manager;

import products.Product;

import java.util.List;
import java.util.ArrayList;

//Only modified by the Manager. Viewed by Everyone
public class GeneralCatalog extends Catalog {
	protected static List<Product> genCat = new ArrayList<Product>();
	
	public GeneralCatalog(){
		
	}
	
	protected void addToCatalog(Product x) {
		genCat.add(x);
	}

	public List<Product> getCatalogList() {
		return genCat;
	}
}