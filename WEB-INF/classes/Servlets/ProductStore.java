package Servlets;

import java.util.HashMap;

public class ProductStore {
	
	 private static HashMap<String, Products> products = new HashMap<String, Products>();

	public static HashMap<String, Products> getProducts() {
		return products;
	}
	 
 public ProductStore() {
	        
	products.put("1", new Products("1", "Xbox1", "400"));
	products.put("2", new Products("2", "Xbox360", "450"));
	products.put("3", new Products("3", "PS3", "500"));
	products.put("4", new Products("4", "PS4", "550"));
	products.put("5", new Products("5", "Wii", "349.99"));
	products.put("6", new Products("6", "WiiU", "449.99"));
	products.put("7", new Products("7", "Nexus", "150"));
	products.put("8", new Products("8", "Ipad", "300"));
	products.put("9", new Products("9", "Fifa 15", "100"));
	products.put("10", new Products("10", "Destiny", "75"));
	products.put("11", new Products("11", "Max Payne", "90"));
	products.put("12", new Products("12", "Xbox Controller", "55"));
	products.put("13", new Products("13", "Play Station Controller", "45"));
	products.put("14", new Products("14", "Wii Controller", "40"));
}

}
