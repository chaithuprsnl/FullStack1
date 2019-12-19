package com.home.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.home.model.Product;
import com.home.repository.ProductRepository;
import com.home.service.ProductService;

@Component
public class ProductQuery implements GraphQLQueryResolver{
	
	@Autowired
	ProductRepository pr;
	
	@Autowired
	ProductService sr;
	
	public List<Product> findAllProducts(){
		return pr.findAll();
	}
	
	public Product findOneProduct(Long id) {
		return sr.getProduct(id);
	}
}
