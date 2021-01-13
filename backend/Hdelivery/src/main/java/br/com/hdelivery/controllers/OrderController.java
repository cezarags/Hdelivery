package br.com.hdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hdelivery.service.OrderService;
import br.com.hdelivery.service.dto.OrderDto;

@RestController
@RequestMapping(value = "/orders")
public class OrderController{
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderDto>> findAll(){
		List<OrderDto> lista = orderService.getAll();
		return ResponseEntity.ok().body(lista);
		
	}
	
	
	
	

}
