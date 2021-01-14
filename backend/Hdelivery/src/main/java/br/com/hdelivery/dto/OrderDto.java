package br.com.hdelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hdelivery.model.Order;
import br.com.hdelivery.model.OrderStatus;

public class OrderDto  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	
	private List<ProductDto> products = new ArrayList<>();
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public OrderDto(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {

		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
		
	}





	public OrderDto(Order order) {
		
		this.id = order.getId();
		this.address =  order.getAndress();
		this.latitude =  order.getLatitude();
		this.longitude = order.getLongitude();
		this.moment = order.getMoment();
		this.status = order.getStatus();
		products = order.getProducts().stream()
				.map(x -> new ProductDto(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductDto> getProducts() {
		return products;
	}
	 
	
	

}
