package com.example.demo;

public class Ola {

	private final long id;
	private final String conteudo;
	
	public Ola(long id, String conteudo) {
		this.id = id;
		this.conteudo = conteudo;
	}
	public long getId() {
		return id;
	}
	public String getConteudo() {
		return conteudo;
	}

	
}