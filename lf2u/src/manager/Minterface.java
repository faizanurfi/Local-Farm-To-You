package manager;

import products.Product;
import reports.*;

import java.util.List;

public interface Minterface {
	Product [] viewCatalog();
	Product getProductByID(int gcpid);
	void addProductToCatalog(Product p);
	void updateCatalogProduct(int gcpid, Product p);
	Manager[] viewAllManagers();
	Manager viewAccount(int mid);
	Report getReport(int mrid, String zip);
	Report[] getAllReports();
}