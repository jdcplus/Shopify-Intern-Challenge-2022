package com.shopify.inventory.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.shopify.inventory.Repositoy.ProductRepository;
import com.shopify.inventory.dto.ProductDTO;
import com.shopify.inventory.entity.Product;
import com.shopify.inventory.exception.ExceptionConstants;
import com.shopify.inventory.exception.InventoryException;
import com.shopify.inventory.utility.UtilityHelper;

@Service
public class ProductServiceImpl implements ProductService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> list = productRepository.findAll();
		List<ProductDTO> inventoryList = new ArrayList<>();
		for (Product product : list) {
			inventoryList.add(UtilityHelper.MapEntityToDTO(product));
		}
		return inventoryList;
	}

	@Override
	public ProductDTO addProduct(ProductDTO product) {
		log.debug("Adding item to inventory :{}", product.toString());
		Product savedProduct = productRepository.save(UtilityHelper.MapDTOToEntity(product));
		log.debug("Item added to the inventory with id {}.", savedProduct.getId());
		return UtilityHelper.MapEntityToDTO(savedProduct);
	}

	@Autowired
	private Environment environment;

	@Override
	public ProductDTO editProduct(Integer productId, ProductDTO productDTO) throws InventoryException {
		Optional<Product> product = productRepository.findById(productId);

		log.info("testing : " + environment.getProperty(ExceptionConstants.GENERAL_ERROR.toString()));
		if (product.isEmpty()) {
			throw new InventoryException("No item exists in the inventory with id " + productId);
		}

		Product entity = product.get();
		entity.setName(productDTO.getName());
		entity.setDescription(productDTO.getDescription());
		entity.setValue(productDTO.getPrice());
		entity.setModifyAt(LocalDateTime.now());
		productRepository.save(entity);

		return UtilityHelper.MapEntityToDTO(entity);
	}

	@Override
	public void deleteProduct(Integer productId) throws InventoryException {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isEmpty()) {
			throw new InventoryException("No item exists in the inventory with id " + productId);
		} else {
			productRepository.delete(product.get());
		}
	}

}
