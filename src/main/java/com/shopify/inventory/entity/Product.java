package com.shopify.inventory.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer Id;

	@Column(name = "product_name")
	private String name;

	@Column(name = "product_description")
	private String description;

	@Column(name = "product_value")
	private BigDecimal value;

	@Column(name = "product_location")
	private String location;

	@Column(name = "product_createdat", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;

	@Column(name = "product_modifyat", columnDefinition = "TIMESTAMP")
	private LocalDateTime modifyAt;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
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
