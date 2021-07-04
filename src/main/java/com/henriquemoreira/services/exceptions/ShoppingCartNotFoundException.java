package com.henriquemoreira.services.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ShoppingCartNotFoundException(Long id) {
		super("ERRO: O carrinho de compras de ID " + id + " não existe.");
	}
}