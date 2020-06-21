package br.bvr.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

import br.bvr.Dao.PessoaDao;
import br.bvr.entidades.Pessoa;



@ViewScoped
@ManagedBean(name = "pessoabean")
public class PessoaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Pessoa pessoa = new Pessoa();
	PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
	
	List<Pessoa> listarTodos = new ArrayList<Pessoa>();
	List<Pessoa> listarUsuarios = new ArrayList<Pessoa>();
	List<Pessoa> listarUser = new ArrayList<Pessoa>();
	List<Pessoa> testeListar = new ArrayList<Pessoa>();
	
	List<Pessoa> usuarioPesquisa = new ArrayList<Pessoa>();
	
	
		public List<Pessoa> getUsuarioPesquisa() {
			usuarioPesquisa = pessoaDao.pesquisarId(pessoa);
			return usuarioPesquisa;
	}





	public void setUsuarioPesquisa(List<Pessoa> usuarioPesquisa) {
		this.usuarioPesquisa = usuarioPesquisa;
	}
	
	// Quando a tela for carregada será caregado a lista de pessoas no datagrid.
		public List<Pessoa> getTesteListar() {
			
			testeListar = pessoaDao.listarTodos();
			return testeListar;
		}

		public void setTesteListar(List<Pessoa> testeListar) {
			this.testeListar = testeListar;
		}





		private Pessoa usuarioLogado;
		
	
			
	
	 
		
	
	public void pesquisarId() {
		
		listarUser = pessoaDao.pesquisarId(pessoa);
		
	}
	
	
	
	public void limparCampos() {
		
		pessoa = new Pessoa();
	}
	
	
	
			
	public void remover() {
		
		pessoaDao.removerPeloID(pessoa);
		pessoa = new Pessoa();
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"","Removido com sucesso!"));
		
	}
	
	
	public void update(){
		
		this.pessoa = pessoaDao.update(pessoa);
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"","Editado com sucesso!"));
		
	}	
	
	
	public void carregarPessoas() {
		listarTodos = PessoaDao.getListEntity(Pessoa.class);
		
		
	}
	
	public void atualizarUsuarioLogado(){
		HttpSession sessao = (HttpSession)FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		this.usuarioLogado = (Pessoa)sessao.getAttribute("usuarioLogado");
		
	}
	
	public void salvar() {
		
		if (pessoa.getSexo().isEmpty()||pessoa.getSobrenome().isEmpty() ||pessoa.getCPF().isEmpty() || pessoa.getNome().isEmpty() || pessoa.getEmail().isEmpty() || pessoa.getSenha().isEmpty()) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ops.", "Todos os campos devem ser preenchidos!!"));
			
		}else {
			
		boolean contemUsuario = false;
		
		this.listarUsuarios = this.pessoaDao.listarTodos();
		
		for(Pessoa usuarioPesquisa : listarUsuarios) {
			if (usuarioPesquisa.getCPF().equals(this.pessoa.getCPF())) {
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
	
	
	
	
	
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}








	public List<Pessoa> getListarUsuarios() {
		return listarUsuarios;
	}

	public void setListarUsuarios(List<Pessoa> listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}

	public PessoaDao<Pessoa> getPessoaDao() {
		return pessoaDao;
	}








	public void setPessoaDao(PessoaDao<Pessoa> pessoaDao) {
		this.pessoaDao = pessoaDao;
	}








	public List<Pessoa> getListarTodos() {
		return listarTodos;
	}








	public void setListarTodos(List<Pessoa> listarTodos) {
		this.listarTodos = listarTodos;
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










	
	
	

}
