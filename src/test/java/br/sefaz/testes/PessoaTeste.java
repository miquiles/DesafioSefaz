package br.sefaz.testes;

import java.sql.SQLException;

import org.junit.Test;

import br.sefaz.Dao.PessoaDao;
import br.sefaz.entidades.Pessoa;

public class PessoaTeste {

		@Test
		public void init() throws SQLException {
			
			Pessoa pessoa = new Pessoa();
			PessoaDao pessoaDao = new PessoaDao();
			
			
			pessoa.setCPF("112");
			pessoa.setEmail("teste@teste");
			pessoa.setSenha("123");
			pessoa.setNome("Amanda");
			pessoa.setSobrenome("Alves");
			pessoa.setSexo("feminino");
			
			pessoaDao.salvarPessoa(pessoa);
			
		}
}
