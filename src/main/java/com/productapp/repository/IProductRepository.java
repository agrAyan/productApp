package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	//derived queries
	// findBy || readBy || getBy
	List <Product> findByCategory(String category);
	List <Product> readByBrand(String brand);
	List<Product> findByPriceLessThan(double price);
	List<Product> findByCategoryAndBrand(String category, String brand);
	List<Product> findByBrandContaining(String brand);
	List<Product> findByCategoryIgnoreCase(String category);
	List<Product> findByCategoryAndPriceLessThan(String category,double price);
	
	//custom query use @Query and JPQL
	//talks in term of entity and instance not table and column
	@Query("from Product p where p.category = ?1")
	List<Product> findByCat(String category);
	
	//talks in term of entity and instance not table and column
		@Query("from Product p where p.category = ?1 and p.brand  = ?2")
		List<Product> findByCatAndBrand(String category, String brand);
	
	@Query("from Product p where p.brand= ?1")
	List <Product> findByBrandName(String brand);
	
	@Query("from Product p where p.price<= ?1")
	List<Product> findByLesserPrice(double price);
	
	@Query("from Product p where p.brand like %?1%")
	List<Product > findByBrandLike(String brand);
	
	@Query(value="select * from newproduct p where p.category=?1 and p.price <= ?2", nativeQuery = true)
	List <Product > findByCatAndPriceLessThan(String category, double price);
}
