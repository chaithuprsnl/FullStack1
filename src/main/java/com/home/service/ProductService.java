package com.home.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.exception.ProductNotFoundException;
import com.home.model.Product;
import com.home.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository prodRepository;

	public Product getProduct(long id) {
		Optional<Product> opProd = prodRepository.findById(id);
		if(opProd.isPresent()) {
			return opProd.get();
		}else {
			throw new ProductNotFoundException("Product requested: "+id+" is not found", id);
		}
	}
}
