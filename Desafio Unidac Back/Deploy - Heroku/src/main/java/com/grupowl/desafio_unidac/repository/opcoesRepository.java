package com.grupowl.desafio_unidac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.grupowl.desafio_unidac.model.Opcoes;

public interface opcoesRepository extends JpaRepository <Opcoes, Long>{
	public List <Opcoes> findAllByItemContainingIgnoreCase(@Param("item") String item);
	
}
