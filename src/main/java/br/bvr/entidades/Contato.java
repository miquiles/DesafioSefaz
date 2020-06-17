package br.bvr.entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


@Entity(name = "contato")
public class Contato 
{
		
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long id;
		
		@Column(nullable = false)
		public String tipo;
		
		@Column(nullable = false)
		public String numero;
		
		@ManyToOne(optional = false, fetch = FetchType.EAGER)
		private Pessoa pessoa;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public Pessoa getPessoa() {
			return pessoa;
		}
		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
	

		
		
}
