package br.sefaz.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "contato")
public class Contato {
		
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long id;
		
		@Column(name = "ddd", nullable = false )
		public int ddd;
		
		@Column(name = "tipo", nullable = false)
		public String tipo;
		
		@Column(name = "numero", nullable = false)
		public String numero;
		
		
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
		
		
}
