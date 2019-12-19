package com.home.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.home.model.Product;
import com.home.repository.ProductRepository;

@Component
public class ProductMutation implements GraphQLMutationResolver{
	
	@Autowired
	ProductRepository pr;
	
	public Product createProduct(String productName, String productCode, String releaseDate, int price,
			String description, double starRating, String imageUrl) {
		
		Product prod = new Product();
		prod.setProductName(productName);
		prod.setProductCode(productCode);
		prod.setReleaseDate(releaseDate);
		prod.setPrice(price);
		prod.setDescription(description);
		prod.setStarRating(starRating);
		prod.setImageUrl(imageUrl);
		
		return pr.saveAndFlush(prod);
	}
}
