package com.henriquemoreira.tests.repositories;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.henriquemoreira.entities.Product;
import com.henriquemoreira.repositories.ProductRepository;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;

	private Long existingId;
	private Long noneExistingId;
	private String newName;


	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		noneExistingId = Long.MAX_VALUE;
		newName = "Headset Gamer";
	}

	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(existingId);

		Optional<Product> result = repository.findById(existingId);
		result.isPresent();

		Assertions.assertFalse(result.isPresent());
	}

	@Test
	public void deleteShouldThrowExceptionWhenIdDoesNotExists() {

		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(noneExistingId);
		});
	}

	@Test
	public void findByNameShouldReturnExistingName() {
		Optional<Product> product = repository.findById(existingId);
		Assertions.assertFalse(product.isEmpty());
	}
	
	@Test
	public void productNameShouldUpdateWhenPassAnExistingId() {
		Product entity = repository.getOne(existingId);
		entity.setName(newName);

		Assertions.assertEquals(newName, entity.getName());
	}

	@Test
	public void updateShouldReturnADefaultMessageWhenUnableToFindTheInformedId() {
		try {	
			Product entity = repository.getOne(noneExistingId);
			entity.setName(newName);
			entity = repository.save(entity);
		} catch (EntityNotFoundException e) {
			String actual = e.getMessage();
			Assertions.assertEquals("Unable to find com.henriquemoreira.entities.Product with id " + Long.MAX_VALUE, actual);
		}
	}
}
