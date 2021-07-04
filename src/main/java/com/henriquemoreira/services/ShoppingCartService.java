package com.henriquemoreira.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.entities.Product;
import com.henriquemoreira.entities.ShoppingCart;
import com.henriquemoreira.repositories.ShoppingCartRepository;
import com.henriquemoreira.services.exceptions.ShoppingCartNotFoundException;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository repository;

	@Autowired
	private ProductService productService;

	public List<ShoppingCart> allShoppingCarts() {
		return repository.findAll();
	}

	public ShoppingCart newShoppingCart(ShoppingCart entity) {
		return repository.save(entity);
	}

	public ShoppingCart findShoppingCartById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ShoppingCartNotFoundException(id));
	}

	public ShoppingCart updateShoppingCartById(Long id, ShoppingCart entity) {
		entity.setId(id);
		return repository.save(entity);
	}

	public void deleteShoppingCartById(Long id) {
		repository.deleteById(id);
	}

	public ShoppingCart insertProduct(Long idCart, Long idProduct) {
		ShoppingCart currentCart = findShoppingCartById(idCart);
		Product currentProduct = productService.findProductById(idProduct);

		currentCart.getProducts().add(currentProduct);

		checkout(idCart, idProduct, 1, currentProduct.getPrice());
		return updateShoppingCartById(idCart, currentCart);
	}

	public ShoppingCart removeProduct(Long idCart, Long idProduct) {
		ShoppingCart currentCart = findShoppingCartById(idCart);
		Product currentProduct = productService.findProductById(idProduct);

		currentCart.getProducts().remove(currentProduct);

		checkout(idCart, idProduct, 0, currentProduct.getPrice());
		return updateShoppingCartById(idCart, findShoppingCartById(idCart));
	}

	public void checkout(Long idCart, Long idProduct, int op, BigDecimal value) {
		BigDecimal unitFreightCost = new BigDecimal(10.00);

		ShoppingCart currentCart = findShoppingCartById(idCart);

		// subtrair ou somar o valor total dos produtos
		if (op == 1) {
			currentCart.setSubtotal(currentCart.getSubtotal().add(value));
		} else {
			currentCart.setSubtotal(currentCart.getSubtotal().subtract(value));
		}

		// calcular o frete
		if (currentCart.getSubtotal().intValue() < 250) {
			if (op == 1) {
				currentCart.setShipping(currentCart.getShipping().add(unitFreightCost));
			} else {
				currentCart.setShipping(currentCart.getShipping().subtract(unitFreightCost));
			}

		} else {
			currentCart.setShipping(new BigDecimal(0.00));
		}

		// valor final a se pagar
		currentCart.setTotal(currentCart.getShipping().add(currentCart.getSubtotal()));
	}
}
