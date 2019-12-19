package com.home.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceHealth implements HealthIndicator{

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return Health.up().withDetail("ProductService", "Available").build();
	}

}
