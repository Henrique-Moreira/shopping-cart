package com.henriquemoreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquemoreira.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
