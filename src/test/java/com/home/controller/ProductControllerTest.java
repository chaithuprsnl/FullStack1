package com.home.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.home.model.Product;
import com.home.repository.ProductRepository;
import com.home.service.ProductService;

public class ProductControllerTest {
	
	@InjectMocks
	private ProductController pc;
	
	@Mock
	private ProductRepository pr;
	
	@Mock
	private ProductService ps;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testProductGet() {
		
		Product prod = new Product();
		prod.setProductId(1L);
		Optional<Product> oprod = Optional.of(prod);
		when(pr.findById(1L)).thenReturn(oprod);
		
		when(ps.getProduct(1L)).thenReturn(prod);

		Product result = pc.getProduct(1L);
		verify(ps).getProduct(1L);
		//assertEquals(1L, result.getProductId()); commented this to check hamcrest annotations
		assertThat(result.getProductId(), is(1L));
	}

}
