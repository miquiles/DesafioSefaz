package br.sefaz.beans;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.sefaz.Dao.ContatoDao;
import br.sefaz.Dao.PessoaDao;
import br.sefaz.entidades.Contato;
import br.sefaz.entidades.Pessoa;


@SessionScoped
@ManagedBean(name = "contatobean")
public class ContatoBean {
	
	private Contato contato = new Contato();
	private ContatoDao contatoDao = new ContatoDao();
	private PessoaDao pessoaDao = new PessoaDao();
	private Pessoa user = new Pessoa();
	
	
	
	public String salvarContato() {
		this.contato = contatoDao.salvarContato(contato);
		return "";
	}



	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ContatoDao getContatoDao() {
		return contatoDao;
	}

	public void setContatoDao(ContatoDao contatoDao) {
		this.contatoDao = contatoDao;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public Pessoa getUser() {
		return user;
	}

	public void setUser(Pessoa user) {
		this.user = user;
	}





	
	
}
