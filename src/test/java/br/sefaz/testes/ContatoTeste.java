package br.sefaz.testes;

import java.sql.SQLException;

import org.junit.Test;

import br.sefaz.Dao.ContatoDao;
import br.sefaz.Dao.PessoaDao;
import br.sefaz.entidades.Contato;
import br.sefaz.entidades.Pessoa;

public class ContatoTeste {
	
	@Test
	public void contato() throws SQLException {
		
		Contato contato = new Contato();
		ContatoDao contatoDao = new ContatoDao();
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = (Pessoa) pessoaDao.pesquisarId(pessoa);
		
		
		contato.setPessoa(pessoa.setId(1));
		contato.setDdd(81);
		contato.setNumero("teste");
		contato.setTipo("Celular");
		
		contatoDao.salvarContato(contato);
		
		
		
		
	}
	
	
}
