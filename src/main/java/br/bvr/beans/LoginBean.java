package br.bvr.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.bvr.Dao.PessoaDao;
import br.bvr.entidades.Pessoa;

@SessionScoped
@ManagedBean(name = "loginbean")
public class LoginBean {
	
	private String txtEmail;
	private String txtSenha;
	
	private List<Pessoa> listarPessoas = new ArrayList<Pessoa>();
	private Pessoa pessoa = new Pessoa();
	private PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
	
	
	
	
	//construtor
	public LoginBean() {
		this.listarPessoas = new ArrayList<Pessoa>();
		this.setPessoa(new Pessoa());
		this.setPessoaDao(new PessoaDao<Pessoa>());
		
	}
	
	public String entrar() {
		
		Pessoa usuarioLogado = null;
		this.listarPessoas = this.pessoaDao.listarTodos();
		
		for (Pessoa usuarioPesquisa : listarPessoas) {
			
			
			if (usuarioPesquisa.getEmail().equals(txtEmail) && usuarioPesquisa.getSenha().equals(txtSenha))  {
				 usuarioLogado = usuarioPesquisa;
			}
		}
		
		if(usuarioLogado != null) {
			
			HttpSession sessao =  (HttpSession)FacesContext.getCurrentInstance()
					.getExternalContext().getSession(true);
			sessao.setAttribute("usuarioLogado", usuarioLogado);
			// testando o retorno 
			return "/paginas/index.xhmtl?faces-redirect=true&amp;includeViewParams=true";
			
		}else {
			
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Por favor", "Verifique os campos"));
			return "";
		}
		
		
	}
	
	
	
	public String getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}
	public String getTxtSenha() {
		return txtSenha;
	}
	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}


	public List<Pessoa> getListarPessoas() {
		return listarPessoas;
	}


	public void setListarPessoas(List<Pessoa> listarPessoas) {
		this.listarPessoas = listarPessoas;
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


	





}