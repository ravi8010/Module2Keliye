package com.capgemini.DAO;

import java.util.List;

import com.capgemini.beans.Product;

public interface ProductDAO {
	
	public Product createProduct(Product product);
	public Product updateProduct(String id,Product product);
	public Product deleteProduct(String id);
	public List<Product> viewProducts();
	public Product findProduct(String id);
	
	
	

}
