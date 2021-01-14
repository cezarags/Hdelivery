package br.com.hdelivery.controllers;

import java.net.URI;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hdelivery.service.OrderService;
import br.com.hdelivery.dto.OrderDto;
import br.com.hdelivery.model.Order;

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

	
	@PostMapping
	public ResponseEntity<OrderDto> insert(@RequestBody OrderDto orderDto){
		orderDto = orderService.insert(orderDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderDto.getId()).toUri();
				return ResponseEntity.created(uri).body(orderDto);		
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDto> setDelivery( @PathVariable  Long id){
		OrderDto  dto = orderService.setDelivery(id); 
		return ResponseEntity.ok().body(dto);
		
		
		
		
	}
	
	
	
	
	
	
	

}
