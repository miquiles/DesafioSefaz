	package br.sefaz.beans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import br.sefaz.Dao.ContatoDao;
import br.sefaz.Dao.DaoGeneric;
import br.sefaz.Dao.PessoaDao;
import br.sefaz.entidades.Contato;
import br.sefaz.entidades.Pessoa;
/**
 * @author Pedro Miquiles
 */

@javax.faces.bean.ViewScoped
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
	
	private List<Contato> listaTelefones = new ArrayList<Contato>();
	
	
	
	
	
	@PostConstruct
	public void init() {
		//Metodo carregará a pessoa selecionada para cadastrar seus telefones. Será passado pelo setParan
		String coduser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigouser");
		user = daoGeneric.pesquisar(Long.parseLong(coduser), Pessoa.class);
	}
	
	
	public String salvarContato() throws Exception {
		
		try {
			
		contato.setPessoa(user);
		contatoDao.salvar(contato);
		contato = new Contato();
		user = daoGeneric.pesquisar(user.getId(), Pessoa.class);
		
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Salvo com sucesso!"));
		
		
		return "relatorio.xhtml";
		}
		catch (Exception e) {
			if (e.getCause() instanceof java.lang.NumberFormatException) {
				return"index.xhtml";
				
			}
		}
		return"";
	}

	
	public String removerTelefone() throws Exception {
		contatoDao.removerPeloID(contato);
		user = daoGeneric.pesquisar(user.getId(), Pessoa.class);
		contato = new Contato();
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Telefone Removido com sucesso!"));
		
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

	//Listará todos os telefones da pessoa selecionada assim que abrir a tela
	public List<Contato> getListaTelefones() {
		listaTelefones = contatoDao.listarTodos();
		return listaTelefones;
	}


	public void setListaTelefones(List<Contato> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}


	




	
	
}
