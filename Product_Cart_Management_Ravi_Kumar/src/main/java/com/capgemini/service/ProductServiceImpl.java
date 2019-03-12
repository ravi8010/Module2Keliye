package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.DAO.ProductDAO;
import com.capgemini.beans.Product;
import com.capgemini.exception.DuplicateIdExistException;
import com.capgemini.exception.IDDoesNotExistException;
import com.capgemini.exception.ProductEmptyException;
@Service //It is used to mark the class as a service provider.
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductDAO pDao; //reference of dao interface
	@Override
	public Product createProduct(Product product) {
		//if product id is already exist then throw an error msgs
		if(pDao.findProduct(product.getId())!=null) 
		{
			throw new DuplicateIdExistException("There is Already Exist Id,please enter different Id");
		}
		return pDao.createProduct(product); //create product using ref of DAO
		
	}

	@Override
	public Product updateProduct(String id,Product product) {
	  
		if(pDao.findProduct(id)==null) //if id not found then throw exception msg
		{
			throw new IDDoesNotExistException("Id does not Exist,please Enter Exist id");
		}
		
		return pDao.updateProduct(id, product);
	}

	@Override
	public Product deleteProduct(String id) {
		
		if(pDao.findProduct(id)==null)//if id not found then throw exception msg
		{
			throw new IDDoesNotExistException("Id does not Exist,please Enter Exist id");
		}
		return pDao.deleteProduct(id);
	}

	@Override
	public List<Product> viewProducts() {
	
		if(pDao.viewProducts().isEmpty())//will check the list is empty or not if true then throw exception
		{
			throw new ProductEmptyException("List is empty.");// 
		}
		
		return pDao.viewProducts();
	}

	@Override
	public Product findProduct(String id) { 
		if(pDao.findProduct(id)==null) //if id not found then throw exception msg
		{
			
			throw new IDDoesNotExistException("Id does not Exist");
		}
		return pDao.findProduct(id);
	}

}
