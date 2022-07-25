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

import com.grupowl.desafio_unidac.model.Opcoes;
import com.grupowl.desafio_unidac.repository.funcionarioRepository;
import com.grupowl.desafio_unidac.repository.opcoesRepository;

@RestController
@RequestMapping ("/opcoes")
@CrossOrigin ("*")
public class opcoesController {
	
	@Autowired
	private opcoesRepository opcoesRep;
	
	@Autowired
	private funcionarioRepository funcionario;
	
	
	@GetMapping
	public ResponseEntity<List<Opcoes>> GetAll() {
		return ResponseEntity.ok(opcoesRep.findAll()); 
		
	}
		
	@GetMapping ("/{id}")
	public ResponseEntity<Opcoes> getById(@PathVariable Long id){
		return opcoesRep.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
		
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Opcoes> post(@Valid @RequestBody Opcoes opcoes){
		if (funcionario.existsById(opcoes.getFuncionario().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).body(opcoesRep.save(opcoes));
	     return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Opcoes> put(@RequestBody Opcoes opcoes){
		if (opcoesRep.existsById(opcoes.getId())){
			if (funcionario.existsById(opcoes.getFuncionario().getId()))
			return ResponseEntity.status(HttpStatus.OK).body(opcoesRep.save(opcoes));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}			
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletar/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Opcoes> opcoes = opcoesRep.findById(id);
		
		if (opcoes.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		opcoesRep.deleteById(id);
		
	}
}
