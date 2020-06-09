package br.sefaz.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.sefaz.Dao.PessoaDao;
import br.sefaz.entidades.Pessoa;



@SessionScoped
@ManagedBean(name = "pessoabean")
public class PessoaBean {
	
	Pessoa pessoa = new Pessoa();
	PessoaDao pessoaDao = new PessoaDao();
	
	List<Pessoa> listarTodos = new ArrayList<Pessoa>();
	List<Pessoa> listarUsuarios = new ArrayList<Pessoa>();
	
	List<Pessoa> testeListar = new ArrayList<Pessoa>();
	
	
		private Pessoa usuarioLogado;
			
		
	
	
	
	
	
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

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}








	public void setPessoaDao(PessoaDao pessoaDao) {
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

	public List<Pessoa> getTesteListar() {
		
		testeListar = pessoaDao.listarTodos();
		return testeListar;
	}

	public void setTesteListar(List<Pessoa> testeListar) {
		this.testeListar = testeListar;
	}










	
	
	

}
