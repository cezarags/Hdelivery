package br.com.hdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hdelivery.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	

}
