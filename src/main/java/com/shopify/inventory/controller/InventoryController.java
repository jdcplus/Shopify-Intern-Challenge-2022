package com.shopify.inventory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.inventory.dto.ProductDTO;
import com.shopify.inventory.exception.InventoryException;
import com.shopify.inventory.service.DataExportService;
import com.shopify.inventory.service.ProductService;

@RestController
public class InventoryController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Autowired
	private DataExportService dataExportService;
	
	@PostMapping("/create")
	public ResponseEntity<ProductDTO> createItem(@RequestBody ProductDTO productDTO) {
		ProductDTO createdProduct = productService.addProduct(productDTO);
		log.info("Item created: {}", createdProduct.toString());
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		log.info("Returned all items");
		return new ResponseEntity<List<ProductDTO>>(productService.getAllProducts(), HttpStatus.OK);
	}

	@PostMapping("/edit/{productId}")
	public ResponseEntity<ProductDTO> editProduct(@PathVariable(name = "productId") Integer productId, 
			@RequestBody ProductDTO productDTO) throws InventoryException {
		ProductDTO editedProduct = productService.editProduct(productId, productDTO);
		log.info("Item with id {} has been edited successfully", productId);
		return new ResponseEntity<>(editedProduct, HttpStatus.OK);
	}

	@PostMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable(name = "productId") Integer productId) 
			throws InventoryException {
		productService.deleteProduct(productId);
		log.info("Item with id {} has been deleted successfully", productId);
		return new ResponseEntity<>("Item has been deleted", HttpStatus.OK);
	}
	
	@GetMapping("/export/csv")
    public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"inventory_export.csv\"");
        dataExportService.writeInventoryToCsv(servletResponse.getWriter());
    }

}
