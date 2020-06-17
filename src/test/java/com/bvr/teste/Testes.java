package com.bvr.teste;

import java.sql.SQLException;

import org.junit.Test;


import br.bvr.Dao.ContatoDao;
import br.bvr.Dao.DaoGeneric;
import br.bvr.Dao.PessoaDao;
import br.bvr.entidades.Contato;
import br.bvr.entidades.Pessoa;

public class Testes {
	
	@Test
	public void testGravarTelefone() throws SQLException {
		DaoGeneric<Pessoa> genericDAO = new DaoGeneric<Pessoa>();
		ContatoDao<Contato> contatoDao = new ContatoDao<Contato>();
		Pessoa pessoa = (Pessoa) genericDAO.pesquisar(1L, Pessoa.class);
		
		Contato telefoneUser = new Contato();
		telefoneUser.setTipo("Empresarial");
		telefoneUser.setNumero("(61) 3397-5465");
		telefoneUser.setPessoa(pessoa);
		contatoDao.salvar(telefoneUser);
	}
	
	@Test
	public void salvarPessoa() throws SQLException{
		//DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<>();
		Pessoa pessoa = new Pessoa();
		PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
		
		pessoa.setNome("pessoaTeste");
		pessoa.setSobrenome("da silva");
		pessoa.setCPF("190");
		pessoa.setEmail("@teste");
		pessoa.setSexo("robô");
		pessoaDao.salvarPessoa(pessoa);
		
		
	}

}
