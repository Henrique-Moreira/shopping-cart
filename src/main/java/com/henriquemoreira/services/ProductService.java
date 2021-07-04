package com.henriquemoreira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.entities.Product;
import com.henriquemoreira.repositories.ProductRepository;
import com.henriquemoreira.services.exceptions.ProductNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> allProducts() {
		return repository.findAll();
	}
	
	public Product newProduct(Product entity) {
		return repository.save(entity);
	}
	
	public Product findProductById(Long id) {
		return repository.findById(id).
				orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	public Product updateProductById(Long id, Product entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	
	
	public void deleteProductById(Long id) {
		repository.deleteById(id);
	}
	
}
