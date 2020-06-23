package br.sefaz.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

import br.sefaz.Dao.ContatoDao;
import br.sefaz.Dao.PessoaDao;
import br.sefaz.entidades.Contato;
import br.sefaz.entidades.Pessoa;

/**
 * @author Pedro Miquiles
 * 
 */


@ViewScoped
@ManagedBean(name = "pessoabean")
public class PessoaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	
	private PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
	
	//Listas
	private List<Pessoa> listarTodos = new ArrayList<Pessoa>();
	private List<Pessoa> listarUsuarios = new ArrayList<Pessoa>();
	private List<Pessoa> listarUser = new ArrayList<Pessoa>();
	private List<Pessoa> usuarioPesquisaPorNome = new ArrayList<Pessoa>();

	//input pesquisa por nome
	private String txtNomePesquisa;
		
	private List<Pessoa> list = new ArrayList<Pessoa>();
	
	private List<Pessoa> relatorioPessoaTelefone = new ArrayList<Pessoa>();
	
	public void pesquisarPorNome() {
		listarUser = pessoaDao.pesquisarPorNome(pessoa.getNome());
	}
	
	
			
	public String remover() throws Exception{
		
		try {
			
			pessoaDao.removerPeloID(pessoa);
			pessoa = new Pessoa();
			
			
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Removido com sucesso!"));
			
		} catch (Exception e) {
				if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
					
					FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"","Para remover um usuário precisa-se excluir seus telefones"));
					
				}
		}
		
		
		return "";
	}
	
	
	public void update(){
		
		pessoaDao.update(pessoa);
		
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"","Editado com sucesso!"));
		
	}	
	
	//encerrará a sessao
	public String sair() {
		
		this.pessoa = new Pessoa();
		return "login.xhtml";
	}
	
	


	private Pessoa usuarioLogado;
	
	
	public void atualizarUsuarioLogado(){
		HttpSession sessao = (HttpSession)FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		this.usuarioLogado = (Pessoa)sessao.getAttribute("usuarioLogado");
		
	}
	
	public void salvar() {
		
		if (pessoa.getNome().isEmpty() || pessoa.getEmail().isEmpty() || pessoa.getSenha().isEmpty()) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ops.", "Todos os campos devem ser preenchidos!!"));
			
		}else {
			
		boolean contemUsuario = false;
		
		this.listarUsuarios = this.pessoaDao.listarTodos();
		
		for(Pessoa usuarioPesquisa : listarUsuarios) {
			if (usuarioPesquisa.getEmail().equals(this.pessoa.getEmail())) {
				contemUsuario =true;
			}
		}if(contemUsuario) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vefique!", "Usuario já existe!!!"));
			
		}else {
		
		this.pessoa = pessoaDao.salvarPessoa(pessoa);
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"","Salvo com sucesso"));
		
		
		
		}
		}
		
		
	}
	
	
	public void setUsuarioPesquisaPorNome(List<Pessoa> usuarioPesquisaPorNome) {
		this.usuarioPesquisaPorNome = usuarioPesquisaPorNome;
	}
	
	public List<Pessoa> getUsuarioPesquisaPorNome() {
		
		usuarioPesquisaPorNome = pessoaDao.pesquisarPorNome(txtNomePesquisa);
		return usuarioPesquisaPorNome;
	}
	
	
	
	// Quando a tela for carregada será caregado a lista de pessoas no datagrid.
			public List<Pessoa> getListarTodos() {
				
				listarTodos = pessoaDao.listarTodos();
				return listarTodos;
			}

			public void setListarTodos(List<Pessoa> listarTodos) {
				this.listarTodos = listarTodos;
			}
	
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}








	public PessoaDao<Pessoa> getPessoaDao() {
		return pessoaDao;
	}








	public void setPessoaDao(PessoaDao<Pessoa> pessoaDao) {
		this.pessoaDao = pessoaDao;
	}










	public Pessoa getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Pessoa usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	

	public List<Pessoa> getListarUser() {
		return listarUser;
	}



	public void setListarUser(List<Pessoa> listarUser) {
		this.listarUser = listarUser;
	}

	

	public String getTxtNomePesquisa() {
		return txtNomePesquisa;
	}

	public void setTxtNomePesquisa(String txtNomePesquisa) {
		this.txtNomePesquisa = txtNomePesquisa;
	}

	public List<Pessoa> getListarUsuarios() {
		return listarUsuarios;
	}

	public void setListarUsuarios(List<Pessoa> listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}



	public List<Pessoa> getList() {
		return list;
	}



	public void setList(List<Pessoa> list) {
		this.list = list;
	}





	public List<Pessoa> getRelatorioPessoaTelefone() {
		relatorioPessoaTelefone = pessoaDao.relatorioPessoaTelefone();
		return relatorioPessoaTelefone;
	}


	public void setRelatorioPessoaTelefone(List<Pessoa> relatorioPessoaTelefone) {
		this.relatorioPessoaTelefone = relatorioPessoaTelefone;
	}








	
	
	

}
