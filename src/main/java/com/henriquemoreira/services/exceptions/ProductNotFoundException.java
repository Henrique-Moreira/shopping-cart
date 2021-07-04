package com.henriquemoreira.services.exceptions;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Long id) {
		super("ERRO: O produto de ID " + id + " não existe.");
	}
}