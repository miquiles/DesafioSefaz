package br.sefaz.test;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import br.sefaz.Dao.PessoaDao;

import br.sefaz.entidades.Pessoa;



public class JunitTest {
	
	@Test
	public void IniciarBanco() throws SQLException {
		
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = new Pessoa();
		
		pessoa.setCPF("testes");
		pessoa.setEmail("testes");
		pessoa.setNome("testes");
		pessoa.setSenha("testes");
		pessoa.setSobrenome("testes");
		
		pessoaDao.salvarPessoa(pessoa);
	}
	

}
