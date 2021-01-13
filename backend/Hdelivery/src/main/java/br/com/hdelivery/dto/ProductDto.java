package br.com.hdelivery.dto;

import java.io.Serializable;

import br.com.hdelivery.model.Product;

public class ProductDto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	
	
	public ProductDto() {
		
	}
	
	
	public ProductDto(Product product) {
		
		this.id = product.getId();
		this.name = product.getNome();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.imageUri =  product.getImageUri();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageUri() {
		return imageUri;
	}


	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
	

}
