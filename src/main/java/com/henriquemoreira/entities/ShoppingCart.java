package com.henriquemoreira.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cart")
public class ShoppingCart {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   @ManyToMany
	   private List<Product> products = new ArrayList<Product>();
	   
	   private BigDecimal shipping;
	   
	   private BigDecimal subtotal;
	   
	   private BigDecimal total;
	   
}
