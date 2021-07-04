package com.henriquemoreira.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;

	   @NotBlank(message = "ERRO: Preencha o campo nome.")
	   private String name;

	   private BigDecimal price;

	   private short score;

	   @NotBlank(message = "ERRO: Preencha o campo imagem.")
	   private String image;
	
}
