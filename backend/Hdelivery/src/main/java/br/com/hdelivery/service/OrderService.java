package br.com.hdelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hdelivery.model.Order;
import br.com.hdelivery.repositories.OrderRepository;
import br.com.hdelivery.service.dto.OrderDto;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<OrderDto> getAll() {
		List<Order> lista = orderRepository.findAll();
		return lista.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
}
