package com.productapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.model.ProductView;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappDatajpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappDatajpaApplication.class, args);
	}
	
	@Autowired
	IProductService productService;
	
	
	@Override
	public void run(String... args) throws Exception {
		Product product= new Product("Mobile",12000.0,"MI","gadgets");
		Product produ=productService.addProduct(product);
//		System.out.println();
//		System.out.println("product added successfully "+ product);
//		//productService.updateProduct(product);
//		System.out.println();
//		System.out.println("------------------------------------------------------------------------");
//		//productService.getAll().forEach(System.out:: println);
//		System.out.println("---------------------------------------------------------------------------------");
//	//	Product productBy=productService.getById(3);
//		//productBy.setProductName("Laptop");
//		//productBy.setPrice(60000);
//		//productBy.setBrand("HP");
//		//productBy.setCategory("Mobile");
//		System.out.println("---------------------------------------------------------------------------------");
//	//	Product productUpadte= productService.updateProduct(productBy);
//		//System.out.println(productUpadte);
//		System.out.println();
//		System.out.println("---------------Get All------------------------------------------------------------------");
//		productService.getAll().forEach(System.out:: println);
//		System.out.println();
//		//productService.deleteProduct(5);
//		System.out.println("----------------category--------------------------");
//		productService.getByCategory("gadgets").forEach(System.out:: println);;
//		System.out.println("----------	Brand  ------------------");
//		System.out.println();
//		productService.getByBrand("Dell").forEach(System.out:: println);
//		System.out.println("-------------Less than Price---------------");
//		productService.findByLessPrice(80000).forEach(System.out:: println);
//		System.out.println();
//		System.out.println("-----------Category and Brand-----------------");
//		productService.findByCategoryAndBrand("gadgets", "Dell").forEach(System.out:: println);
//		
//		System.out.println();
//		System.out.println("-------------Brand Like ---------------");
//		productService.getByBrandLike("A").forEach(System.out:: println);
//		System.out.println();
//		System.out.println("----------------Category Ignore Case------------");
//		productService.getByCategoryIgnoreCase("GADGETS").forEach(System.out:: println);
//		System.out.println();
//		System.out.println("------------Category And Price----------------");
//		
//		productService.getByCategoryAndPrice("gadgets", 100000.0).forEach(System.out:: println);
	
		productService.getDetailsByCategory("gadgets").forEach(System.out:: println);
		
		//System.out.println(productService.getByName("Mac Book").getPrice());
	 System.out.println(productService.getByProductName("Mi NoteBook"));
	
	List<ProductView> productDetails= productService.getProductByBrand("Poco");
	productDetails.stream().forEach((prod)->{
		System.out.println(prod.getDetails());
	});
	}

}
