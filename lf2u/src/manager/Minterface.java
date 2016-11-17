package manager;

import products.Product;
import reports.*;

import java.util.List;

public interface Minterface {
	Product [] viewCatalog();
	void addProductToCatalog(Product p);
	void updateCatalogProduct(int gcpid, Product p);
	List<Manager> viewAllManagers();
	Manager viewAccount(int mid);
	Report getReport();
}