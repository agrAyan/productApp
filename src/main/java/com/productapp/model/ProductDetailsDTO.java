package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

// DTO PROJECTION USING CLASS
// SHOULD HAVE INSTANCE VARIABLES SIMILAR TO THE ENTITY CLASS(WHATEVER REQUIRED)
//SHOULD HAVE ONLY ONE CONSTRUCTOR WITH ALL THE PARAMETERS
public class ProductDetailsDTO {
	private String productName;
	private String brand;
}
