package br.sefaz.beans;

import java.util.ArrayList;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.sefaz.Dao.DaoGeneric;
import br.sefaz.entidades.Contato;
import br.sefaz.entidades.Pessoa;

/**
 * @author Pedro Miquiles
 */
@SessionScoped
@ManagedBean(name = "consultabean")
public class ConsultaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Contato> daoGeneric = new DaoGeneric<Contato>();
	private List<Contato> lista = new ArrayList<Contato>();
	
	public void listagem() {
		setLista(daoGeneric.todos());
	}
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public DaoGeneric<Contato> getDaoGeneric() {
		return daoGeneric;
	}
	public void setDaoGeneric(DaoGeneric<Contato> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}


	//Carregará a lista feita com inner join entre Pessoa e Telefones
	public List<Contato> getLista() {
		lista = daoGeneric.todos();
		return lista;
	}



	public void setLista(List<Contato> lista) {
		this.lista = lista;
	}
	
	
	
	
}
