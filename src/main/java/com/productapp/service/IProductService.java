package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.IBrandView;
import com.productapp.model.Product;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.model.ProductView;

public interface IProductService {
	
Product addProduct(Product product);
Product updateProduct(Product product);
void deleteProduct(int productId);
Product getById(int productId) throws ProductNotFoundException;
List<Product> getAll() throws ProductNotFoundException;
List<Product> getByCategory(String category) throws ProductNotFoundException;
List<Product> getByBrand(String brand) throws ProductNotFoundException;
List<Product> findByLessPrice(double price) throws ProductNotFoundException;
List<Product> findByCategoryAndBrand(String category, String brand);
List<Product> getByBrandLike(String brand);
List<Product> getByCategoryIgnoreCase(String category);
List<Product> getByCategoryAndPrice(String category,double price);


//Projection
List<ProductDetailsDTO> getDetailsByCategory(String category);

IBrandView getByProductName(String productName);

//IPriceView getByName(String productName);
List<ProductView> getProductByBrand(String brand);

}
