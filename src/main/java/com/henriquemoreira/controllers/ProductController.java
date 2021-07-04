package com.henriquemoreira.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquemoreira.entities.Product;
import com.henriquemoreira.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService service;

	// busca todos os produtos criados
	@GetMapping
	public List<Product> products() {
		return service.allProducts();
	}
	
	// cria um novo produto
	@PostMapping
	public ResponseEntity<String> newProduct(@Valid @RequestBody Product entity) {
		service.newProduct(entity);
		return ResponseEntity.ok("Produto cadastrado com sucesso.");
	}
	
	// busca os dados de um produto pelo id
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable Long id) {
		return service.findProductById(id);
	}
	
	// edita os dados de um produto
	@PutMapping("/{id}")
	public Product updateProductById(@PathVariable Long id, @RequestBody Product entity) {
		return service.updateProductById(id, entity);
	}
	
	
	// deleta os dados de um um produto pelo id
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable Long id) {
		service.deleteProductById(id);
	}

}
