package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Produces(MediaType.APPLICATION_JSON)
public class OlaController {

	private static final String template = "Olá, %s!";
	private final AtomicLong contador = new AtomicLong();

	@GetMapping("/ola")
	public Ola ola(@RequestParam(value = "nome", defaultValue = "Mundo") String nome) {
		return new Ola(contador.incrementAndGet(), String.format(template, nome));
	}
	
}