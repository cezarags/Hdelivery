package br.com.hdelivery.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.hdelivery.model.Order;
import br.com.hdelivery.model.OrderStatus;
import br.com.hdelivery.model.Product;
import br.com.hdelivery.repositories.OrderRepository;
import br.com.hdelivery.repositories.ProductRepository;
import net.bytebuddy.implementation.bind.annotation.Super.Instantiation;
import br.com.hdelivery.dto.OrderDto;
import br.com.hdelivery.dto.ProductDto;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDto> getAll() {
		List<Order> lista = orderRepository.findOrdersWithProducts();
		return lista.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
	
	@PostMapping
	@Transactional
	public OrderDto insert (OrderDto orderDto){
		Order order = new Order(null, orderDto.getAddress(), orderDto.getLatitude(), orderDto.getLongitude(), Instant.now(), OrderStatus.PENDING );
		for(ProductDto p : orderDto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = orderRepository.save(order);
		return new OrderDto(order);
		
	}
}
