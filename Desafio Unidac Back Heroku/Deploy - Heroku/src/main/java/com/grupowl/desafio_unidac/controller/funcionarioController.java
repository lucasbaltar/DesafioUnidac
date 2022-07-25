package com.grupowl.desafio_unidac.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.grupowl.desafio_unidac.model.Funcionario;
import com.grupowl.desafio_unidac.repository.funcionarioRepository;

@RestController
@RequestMapping ("/funcionario")
@CrossOrigin("*")
public class funcionarioController {
	
	@Autowired
	private funcionarioRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity <List<Funcionario>> getAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable Long id) {
		return repository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Funcionario> post(@Valid @RequestBody Funcionario funcionario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(funcionario));
		}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Funcionario> put(@RequestBody Funcionario produto){
		return repository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
					.body(repository.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletar/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Funcionario> funcionario = repository.findById(id);
		
		if (funcionario.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		repository.deleteById(id);
		
	}

}
