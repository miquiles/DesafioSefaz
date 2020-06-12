package br.sefaz.entidades;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




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
	
	@Column(name = "sexo", nullable = false)
	private String sexo;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Contato> contato;
	
	
	public List<Contato> getContato() {
		return contato;
	}
	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	

}
