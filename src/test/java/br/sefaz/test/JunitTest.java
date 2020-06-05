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
		
		pessoa.setCPF("0101");
		pessoa.setEmail("roberto@carlos.henry");
		pessoa.setNome("Robero");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Carlos");
		pessoa.setSexo("M");
		
		pessoaDao.salvarPessoa(pessoa);
	}
	

}
