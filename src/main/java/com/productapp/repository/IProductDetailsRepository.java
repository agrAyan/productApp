package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.IBrandView;
import com.productapp.model.Product;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.model.ProductView;

@Repository
public interface IProductDetailsRepository extends JpaRepository<Product, Integer> {

	//this repository is to handle projections - dto projections
	List<ProductDetailsDTO> findByCategory(String category);
	
	IBrandView findByProductName(String productName);
	//@Query("from Product p where p.productName=?1")
	//IPriceView findByProductName(String productName);

	List<ProductView> findByBrand(String brand);
}
