package com.productapp.model;

import org.springframework.beans.factory.annotation.Value;

public interface ProductView {
	
	
	//Open Projections
	@Value("#{target.productName+'   '+ target.price}")
	String getDetails();
}
