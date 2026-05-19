package com.example.creatorstore.controllers;
import com.example.creatorstore.entities.Product;
import com.example.creatorstore.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	// Post Endpoint for product
	@PostMapping
	public Product createProduct(@Valid @RequestBody Product product){
		return null;
	}
	
	// Update Endpoint for product
	@PutMapping
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
		return null;
	}
	
	// get all products endpoint
	@GetMapping
	public List<Product> getProducts(){
		return null;
	}
	
	// get single product endpoint
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return null;
	}
	
	// delete endpoint for product
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {}
}
