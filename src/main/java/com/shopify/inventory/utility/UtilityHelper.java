package com.shopify.inventory.utility;

import java.time.LocalDateTime;

import com.shopify.inventory.dto.ProductDTO;
import com.shopify.inventory.entity.Product;

public class UtilityHelper {

	public static Product MapDTOToEntity(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setValue(dto.getPrice());
		entity.setLocation(dto.getLocation());
		entity.setCreatedAt(LocalDateTime.now());
		entity.setModifyAt(LocalDateTime.now());
		return entity;
	}
	
	public static ProductDTO MapEntityToDTO(Product entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setPrice(entity.getValue());
		dto.setLocation(entity.getLocation());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setModifyAt(entity.getModifyAt());
		return dto;
	}
	
	
}
