package br.com.hdelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hdelivery.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByNameAsc();

}
