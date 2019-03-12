package com.capgemini.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.beans.Product;

@Repository//it marks the specific class as a Data Access Object,
@Transactional //it  defines the scope of a single database transaction.
public class ProductDAOImpl implements ProductDAO {
	@PersistenceContext
	private EntityManager entityManager; //Makiing the reference of Entity manager
	
	
	@Override
	public Product createProduct(Product product) { //Method to create Product 
		 entityManager.persist(product);//this will add the product
		 return product;
	
	}

	

	@Override
	public Product deleteProduct(String id) { //method to delete product by id
		Product product= entityManager.find(Product.class, id); //first this will find then store in product
		entityManager.remove(product);//this will remove the product of passed id
		entityManager.flush(); //this will force the data to be persist in the database immediately
		return product;
	}

	@Override
	public List<Product> viewProducts() { //method to show  all the products
		
		// select all the product from table 
		Query query=entityManager.createNativeQuery("select * from Product1");
		
		
		List<Product> list=query.getResultList();// store in list 
		return list;//return list
	}

	@Override
	public Product findProduct(String id) {  // find the product through id and print the detail of that id
		Product product= entityManager.find(Product.class, id);
		return product;
	}



	@Override
	public Product updateProduct(String id, Product product) {
		
		Product productdtoref=entityManager.find(Product.class,id);
		entityManager.remove(productdtoref);
		entityManager.persist(product);
		
		return product;
	}

}
