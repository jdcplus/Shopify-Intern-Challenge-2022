package com.shopify.inventory.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopify.inventory.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
