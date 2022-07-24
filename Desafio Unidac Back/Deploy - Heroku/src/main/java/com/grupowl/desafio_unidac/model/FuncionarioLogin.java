package com.grupowl.desafio_unidac.model;

public class FuncionarioLogin {
	
	private Long id;
	private String nome;
	private String cpf;
	private String token;
	


	public FuncionarioLogin(Long id, String nome, String cpf, String token) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.token = token;
	}
	
	public FuncionarioLogin() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	




}