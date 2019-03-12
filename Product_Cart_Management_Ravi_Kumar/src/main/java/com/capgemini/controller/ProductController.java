package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Product;
import com.capgemini.service.ProductService;

@RestController //@RestController is a special controller used in RESTFul web services
public class ProductController {
	
	
	@Autowired(required=true) // @Autowired annotation is used for automatic dependency injection
	/*
	we don't need to create object,It will automatically create object by
    just using reference of ProductService Interface*/
	private ProductService serviceref;
	
	@RequestMapping(method=RequestMethod.GET,value="/products") //In the json app ,we will pass the products as url.
	public List<Product> findAll(){    //It will print all the products that are in product table by usinng the reference of servicelayer
		return serviceref.viewProducts();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/products")//to create product,we will pass createProduct in the url
	public Product createProduct(@RequestBody Product product) { //For creating the product
		return serviceref.createProduct(product);
		}
	
	@RequestMapping(method=RequestMethod.GET,value="/products/{id}") 
	public Product findProduct(@PathVariable String id) { //This method will find the product using id
		return serviceref.findProduct(id);
		}
	
	@RequestMapping(method=RequestMethod.PUT,value="/products/{id}")  //pass the updateProduct in url and id and it will update the product
	public Product updateProduct(@PathVariable String id,@RequestBody Product product) {
		return serviceref.updateProduct(id, product);//
		}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
	public Product delete(@PathVariable String id) { //it will delete the product by giving the id
		return serviceref.deleteProduct(id);
		}	

}
