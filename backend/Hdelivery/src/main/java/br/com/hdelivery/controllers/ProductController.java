package br.com.hdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hdelivery.dto.ProductDto;
import br.com.hdelivery.model.Product;
import br.com.hdelivery.repositories.ProductRepository;
import br.com.hdelivery.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	
	@Autowired
	ProductService productservice;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> listfull(){
		List<ProductDto> lista = productservice.getAll();
		return ResponseEntity.ok().body(lista);
		
	}
	
	

}
