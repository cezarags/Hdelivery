package br.com.hdelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.hdelivery.dto.ProductDto;
import br.com.hdelivery.model.Order;
import br.com.hdelivery.model.Product;
import br.com.hdelivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	@Transactional(readOnly = true)
	public List<ProductDto> getAll(){
		List<Product> lista = productRepository.findAllByOrderByNameAsc();
		return lista.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
	}
	

}
