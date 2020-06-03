package br.sefaz.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity(name = "pessoa")
public class Pessoa {
	
	@Id 
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "cpf", nullable = false)
	private String CPF;
	@Column (name = "email", nullable = false)
	private String email;
	@Column(name = "senha", nullable = false)
	private String senha;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "sobrenome", nullable = false)
	private String sobrenome;
	

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	
	

}
