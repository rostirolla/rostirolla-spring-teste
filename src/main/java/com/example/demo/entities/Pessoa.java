package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pessoa {

	@Getter
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idpessoa")
	private Long id;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private int idade;
	
}
