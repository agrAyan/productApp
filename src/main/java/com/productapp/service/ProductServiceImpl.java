package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.IBrandView;
import com.productapp.model.Product;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.model.ProductView;
import com.productapp.repository.IProductDetailsRepository;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	

	@Autowired
	IProductDetailsRepository productDetRepository;
	
	public void setProductDetRepository(IProductDetailsRepository productDetRepository) {
		this.productDetRepository = productDetRepository;
	}
	
	@Autowired
	IProductRepository productRepository;

	@Autowired
	public void setProductRepository(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(int productId) {
	productRepository.deleteById(productId);
		
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
//		Optional<Product> prodOpt= productRepository.findById(productId);
//		if(prodOpt.isEmpty())
//			throw new ProductNotFoundException("id not available");
//		return prodOpt.get();
		
		
		return productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("invalid id"));
	}

	@Override
	public List<Product> getAll() throws ProductNotFoundException {
		return productRepository.findAll();
	
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		//return productRepository.findByCategory(category);
		return productRepository.findByCat(category);
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
	//return productRepository.readByBrand(brand);
		return productRepository.findByBrandName(brand);
	}

	@Override
	public List<Product> findByLessPrice(double price) throws ProductNotFoundException {
		
		//return productRepository.findByPriceLessThan(price);
		return productRepository.findByLesserPrice(price);
	}

	@Override
	public List<Product> findByCategoryAndBrand(String category, String brand) {
		
		//return productRepository.findByCategoryAndBrand(category, brand);
		return productRepository.findByCatAndBrand(category, brand);
	}

	@Override
	public List<Product> getByBrandLike(String brand) {
		
		//return productRepository.findByBrandContaining(brand);
		return productRepository.findByBrandLike(brand);
	}

	@Override
	public List<Product> getByCategoryIgnoreCase(String category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategoryIgnoreCase(category);
	}

	@Override
	public List<Product> getByCategoryAndPrice(String category, double price) {
		// TODO Auto-generated method stub
		//return productRepository.findByCategoryAndPriceLessThan(category, price);
		return productRepository.findByCatAndPriceLessThan(category, price);
	}

	@Override
	public List<ProductDetailsDTO> getDetailsByCategory(String category) {
		// TODO Auto-generated method stub
	return productDetRepository.findByCategory(category);
	}



	//projection
	@Override
	public IBrandView getByProductName(String productName) {
		// TODO Auto-generated method stub
		return productDetRepository.findByProductName(productName);
	}



	@Override
	public List<ProductView> getProductByBrand(String brand) {
		// TODO Auto-generated method stub
		return productDetRepository.findByBrand(brand);
	}



//	@Override
//	public IPriceView getByName(String productName) {
//		// TODO Auto-generated method stub
//		return productDetRepository.findByProductName(productName);
//	}
//	
	

}
