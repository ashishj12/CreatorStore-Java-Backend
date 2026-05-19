package com.example.creatorstore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.creatorstore.entities.Product;
import com.example.creatorstore.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	// create product service
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	// update product service
	public Product updateProduct(Long id, Product product) {

		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found by id " + id));

		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setStockQuantity(product.getStockQuantity());

		return productRepository.save(existingProduct);
	}

	// get all products service
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	// get product by id service
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found by id" + id));
	}

	public void deleteProduct(Long id) {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id " + id));

		productRepository.delete(product);
	}
}
