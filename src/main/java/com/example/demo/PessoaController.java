package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pessoa;
import com.example.demo.repositories.PessoaRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public ResponseEntity<List<Pessoa>> listPessoas() {
		return new ResponseEntity<List<Pessoa>>(pessoaRepository.findAll(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable("id") Long id) {
		if (pessoaRepository.findById(id).isPresent())
			return new ResponseEntity<Pessoa>(pessoaRepository.findById(id).get(), new HttpHeaders(), HttpStatus.OK);
		return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaRepository.save(pessoa), new HttpHeaders(), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> deletePessoa(@PathVariable("id") Long id) {
		pessoaRepository.deleteById(id);
		return new ResponseEntity<Pessoa>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> putPessoa(@RequestBody Pessoa pessoa) throws NotFoundException {
		if (pessoa.getId() == null || !pessoaRepository.existsById(pessoa.getId()))
			throw new NotFoundException("Id inválido ou inexistente.");
		return new ResponseEntity<Pessoa>(pessoaRepository.save(pessoa), new HttpHeaders(), HttpStatus.OK);
	}
}