package manager;

import products.Product;

public abstract class Catalog {
	public enum catalogProduct{CABBAGE, CHEESE, CUCUMBER, EGG, EGGPLANT, HONEY, MEAT, MILK, POTATO, TOMATO};
	
	abstract void addToCatalog(Product p);
}