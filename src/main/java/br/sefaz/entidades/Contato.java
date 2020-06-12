package br.sefaz.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "contato")
public class Contato {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		public Long id;
		
		@Column(name = "ddd", nullable = false )
		public int ddd;
		
		@Column(name = "tipo", nullable = false)
		public String tipo;
		
		@Column(name = "numero", nullable = false)
		public String numero;
		
		@ManyToOne(optional = false, fetch = FetchType.EAGER)
		@JoinColumn(name = "id_pessoa")
		private Pessoa pessoa;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getDdd() {
			return ddd;
		}
		public void setDdd(int ddd) {
			this.ddd = ddd;
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
