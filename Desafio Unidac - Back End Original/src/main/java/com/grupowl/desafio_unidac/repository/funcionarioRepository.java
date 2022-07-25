package com.grupowl.desafio_unidac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupowl.desafio_unidac.model.Funcionario;

@Repository
public interface funcionarioRepository extends JpaRepository <Funcionario, Long> {
	
	public List <Funcionario> findAllByNomeContainingIgnoreCase(String nome);
}
