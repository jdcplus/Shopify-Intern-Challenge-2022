package com.shopify.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDTO {
	
	Integer id;
	String name;
	String description;
	BigDecimal price;
	String location;
	LocalDateTime createdAt;
	LocalDateTime modifyAt;

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", location=" + location + ", createdAt=" + createdAt + ", modifyAt=" + modifyAt + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifyAt() {
		return modifyAt;
	}

	public void setModifyAt(LocalDateTime modifyAt) {
		this.modifyAt = modifyAt;
	}
}
