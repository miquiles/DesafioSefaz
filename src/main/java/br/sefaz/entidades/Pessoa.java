package br.sefaz.entidades;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;





@Entity(name = "pessoa")
public class Pessoa  {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column (name = "email" ,nullable = false)
	private String email;
	@Column(name = "senha" ,nullable = false)
	private String senha;
	@Column(name = "nome" ,nullable = false)
	private String nome;
	
	
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,orphanRemoval = true)
	private List<Contato> contato = new ArrayList<Contato>();
	
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
