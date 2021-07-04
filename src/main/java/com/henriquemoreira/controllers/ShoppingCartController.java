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

import com.henriquemoreira.entities.ShoppingCart;
import com.henriquemoreira.services.ShoppingCartService;

@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService service;

	// busca todos os carrinhos de compras criados
	@GetMapping
	public List<ShoppingCart> shoppingCarts() {
		return service.allShoppingCarts();
	}
	
	// cria um novo carrinho de compras
	@PostMapping
	public ResponseEntity<String> newShoppingCart(@Valid @RequestBody ShoppingCart entity) {
		service.newShoppingCart(entity);
		return ResponseEntity.ok("Carrinho de compras cadastrado com sucesso.");
	}
	
	// busca os dados de um carrinho de compras pelo id
	@GetMapping("/{id}")
	public ShoppingCart findShoppingCartById(@PathVariable Long id) {
		return service.findShoppingCartById(id);
	}
	
	// edita os dados de um carrinho de compras
	@PutMapping("/{id}")
	public ShoppingCart updateShoppingCartById(@PathVariable Long id, @RequestBody ShoppingCart entity) {
		return service.updateShoppingCartById(id, entity);
	}
	
	// deleta os dados de um um carrinho de compras pelo id
	@DeleteMapping("/{id}")
	public void deleteShoppingCartById(@PathVariable Long id) {
		service.deleteShoppingCartById(id);
	}
	
	// vincula um produto a um carrinho de compras passando os ids
	@PutMapping("/add/{idCart}/{idProduct}")
	public ResponseEntity<String> insertProduct(@PathVariable Long idCart, @PathVariable Long idProduct) {
		service.insertProduct(idCart, idProduct);
		return ResponseEntity.ok("Produto adicionado com sucesso.");
	}
	
	// desvincula um produto a um carrinho de compras passando os ids
	@PutMapping("/remove/{idCart}/{idProduct}")
	public ResponseEntity<String> removeProduct(@PathVariable Long idCart, @PathVariable Long idProduct) {
		service.removeProduct(idCart, idProduct);
		return ResponseEntity.ok("Produto removido com sucesso.");
	}
}
