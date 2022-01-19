package com.shopify.inventory.service;

import java.util.List;

import com.shopify.inventory.dto.ProductDTO;
import com.shopify.inventory.exception.InventoryException;

public interface ProductService {

	List<ProductDTO> getAllProducts();

	ProductDTO addProduct(ProductDTO product) throws InventoryException;

	ProductDTO editProduct(Integer productId, ProductDTO productDTO) throws InventoryException;

	void deleteProduct(Integer productId) throws InventoryException;
}
