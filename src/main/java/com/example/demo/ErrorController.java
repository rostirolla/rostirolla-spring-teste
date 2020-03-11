package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

	private static final String template = "Olá, %s!";
	private final AtomicLong contador = new AtomicLong();

	@GetMapping("/error")
	public String error() {
		return "Página inválida!";
	}
	
}