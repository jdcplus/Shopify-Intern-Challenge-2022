package com.shopify.inventory.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.inventory.Repositoy.ProductRepository;
import com.shopify.inventory.entity.Product;

@Service
public class DataExportService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepositoy;

	public void writeInventoryToCsv(Writer writer) {
		List<Product> products = productRepositoy.findAll();
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for (Product product : products) {
				csvPrinter.printRecord(product.getId(), product.getName(), product.getDescription(), product.getValue(),
						product.getLocation(), product.getCreatedAt(), product.getModifyAt());
			}
		} catch (IOException e) {
			log.error(e.getStackTrace().toString());
		}
	}
}
