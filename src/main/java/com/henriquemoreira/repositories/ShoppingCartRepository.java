package com.henriquemoreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquemoreira.entities.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
