package com.home.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.home.model.Product;

public class ProductStub {
	
	private static Map<Long, Product> products = new HashMap<Long, Product>();
	private static Long idIndex = 3L;
	
	static {
		Product prod1 = new Product(1L,"Radio","RD-234","01-01-2016",334,"Old Vintage Radio",3.4,"");
		products.put(1L, prod1);
		
		Product prod2 = new Product(2L,"Television","TV-2434","03-05-2019",10000,"Color Television LED",4.9,"");
		products.put(2L, prod2);
		
		Product prod3 = new Product(3L,"Mobile","MB-879","01-12-2019",4500,"Lenovo KLite",3,"");
		products.put(3L, prod3);
	}
	
	public static List<Product> getProducts(){
		return new ArrayList<Product>(products.values());
	}
	
	public static Product createProduct(Product prod) {
		idIndex += 1;
		prod.setProductId(idIndex);
		products.put(idIndex, prod);
		return prod;
	}
	
	public static Product updateProduct(Long id, Product prod) {
		products.put(id, prod);
		return prod;
	}
	
	public static Product removeProduct(Long id) {
		return products.remove(id);
	}
	
	public static Product getProduct(Long id) {
		return products.get(id);
	}
}
