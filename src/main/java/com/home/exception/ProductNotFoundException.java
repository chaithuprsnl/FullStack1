package com.home.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class ProductNotFoundException extends RuntimeException implements GraphQLError{
	
	private Map<String, Object> extensions = new HashMap<String, Object>();
	
	public ProductNotFoundException(String message, Long invalidApplicationId) {
		super(message);
		extensions.put("invalidApplicationId", invalidApplicationId);
	}

	@Override
	public ErrorType getErrorType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}
}
