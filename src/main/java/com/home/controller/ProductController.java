package com.home.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.home.exception.ErrorMessage;
import com.home.exception.FieldErrorMessages;
import com.home.exception.ProductNotFoundException;
import com.home.model.Product;
import com.home.repository.ProductRepository;
import com.home.service.ProductService;

@RestController
@RequestMapping("addr/v1")
public class ProductController {
	
	@Autowired
	ProductRepository prodRepository;
	
	@Autowired
	ProductService prodService;
	
	/*@RequestMapping(value="create", method=RequestMethod.POST)
	public Product addAddress(@RequestBody Product prod){
		if(prod.getProductId() == 0 && prod.getProductName()!=null) {
			return prodRepository.saveAndFlush(prod);
		}else {
			throw new ValidationException("Product cannot be created");
		}
		
	}*/
	
	/**
	 * Using validation api
	 * @param prod
	 * @return
	 */
	@RequestMapping(value="create", method=RequestMethod.POST)
	public Product addAddress(@Valid @RequestBody Product prod){
			return prodRepository.saveAndFlush(prod);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FieldErrorMessages> exceptionHandlerAddress(MethodArgumentNotValidException ve){
		List<FieldError> fieldErrors = ve.getBindingResult().getFieldErrors();
		List<FieldErrorMessages> list = fieldErrors.stream().map(fieldError -> new FieldErrorMessages(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
		return list;
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Product>> getProducts(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_XML);
		return new ResponseEntity<List<Product>>(prodRepository.findAll(), httpHeaders, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public Product updateProduct(@PathVariable Long id, @RequestBody Product prod){
		Product exprod = prodRepository.findById(id).get();
		BeanUtils.copyProperties(prod, exprod);
		return prodRepository.saveAndFlush(exprod);
	}*/
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	public Product removeProduct(@PathVariable Long id){
		Product exprod = prodRepository.findById(id).get();
		prodRepository.delete(exprod);
		return exprod;
	}
	
	@RequestMapping(value="getprod/{id}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable Long id){
		try {
			return prodService.getProduct(id);
		}catch(ProductNotFoundException pne){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, pne.getMessage());
		}
	}
	
	/**
	 * Handling exceptions locally in a method
	 */
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Product> updateValidProduct(@PathVariable Long id, @RequestBody Product prod){
		if(prodRepository.findById(id).isPresent()) {
			Product exprod = prodRepository.findById(id).get();
			BeanUtils.copyProperties(prod, exprod);
			return new ResponseEntity<Product>(prodRepository.saveAndFlush(exprod), HttpStatus.OK);
		}else {
			return new ResponseEntity<Product>(prod, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Handling exceptions using ExceptionHandler
	 */ 
	/*@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> exceptionHandler(ValidationException ve){
		return new ResponseEntity<String>(ve.getMessage(), HttpStatus.BAD_REQUEST);
	}*/
	
	/**
	 * Handling exceptions using ExceptionHandler and return ErrorMEssage object instead of ResponseEntity
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public ErrorMessage exceptionHandlerErrorMessage(ValidationException ve){
		
		ArrayList<String> list = new ArrayList<String>();
		list.
		
		return new ErrorMessage("400", ve.getMessage());
	}
}
