package br.bvr.beans;



import java.io.Serializable;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.bvr.Dao.ContatoDao;
import br.bvr.Dao.DaoGeneric;
import br.bvr.Dao.PessoaDao;
import br.bvr.entidades.Contato;
import br.bvr.entidades.Pessoa;


@ViewScoped
@ManagedBean(name = "contatobean")
public class ContatoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Contato contato = new Contato();
	private ContatoDao<Contato> contatoDao = new ContatoDao<Contato>();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	
	private PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
	private Pessoa user = new Pessoa();
	
	
	
	
	@PostConstruct
	public String init() {
		String coduser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigouser");
		user = pessoaDao.pesquisar(Long.parseLong(coduser), Pessoa.class);
		
		
		return "";
	}
	
	
	public String salvarContato() {
		contato.setPessoa(user);
		contatoDao.salvar(contato);
		contato = new Contato();
		
		
		
		return "";
	}



	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}



	public ContatoDao<Contato> getContatoDao() {
		return contatoDao;
	}


	public void setContatoDao(ContatoDao<Contato> contatoDao) {
		this.contatoDao = contatoDao;
	}


	public PessoaDao<Pessoa> getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao<Pessoa> pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public Pessoa getUser() {
		return user;
	}

	public void setUser(Pessoa user) {
		this.user = user;
	}


	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}


	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}







	
	
}
