package br.sefaz.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import br.sefaz.Dao.ContatoDao;
import br.sefaz.entidades.Contato;


@SessionScoped
@ManagedBean(name = "contatobean")
public class ContatoBean {
	
	Contato contato = new Contato();
	ContatoDao contatoDao = new ContatoDao();
	//metodo será chamado quando o maneged bean for constuido na tela
	//@PostConstruct
//	public void init() {
		
		
	//}
	
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



	
	
}
