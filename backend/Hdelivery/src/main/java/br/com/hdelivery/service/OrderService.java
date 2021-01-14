package br.com.hdelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hdelivery.model.Order;
import br.com.hdelivery.repositories.OrderRepository;
import br.com.hdelivery.dto.OrderDto;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Transactional(readOnly = true)
	public List<OrderDto> getAll() {
		List<Order> lista = orderRepository.findOrdersWithProducts();
		return lista.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
}
