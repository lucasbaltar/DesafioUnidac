package com.grupowl.desafio_unidac.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Digite o seu nome")
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("funcionario")
	private List<Opcoes> opcoes;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String cpf) 
	{
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Opcoes> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Opcoes> opcoes) {
		this.opcoes = opcoes;
	}
	
	
	
}
