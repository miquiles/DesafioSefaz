package com.bvr.teste;

import java.sql.SQLException;
/**
 * @author Pedro Miquiles
 */
import java.util.List;

import org.junit.Test;

import br.sefaz.Dao.ContatoDao;
import br.sefaz.Dao.DaoGeneric;
import br.sefaz.Dao.PessoaDao;
import br.sefaz.entidades.Contato;
import br.sefaz.entidades.Pessoa;

public class Testes {
	
	@Test
	public void testGravarTelefone() throws SQLException {
		DaoGeneric<Pessoa> genericDAO = new DaoGeneric<Pessoa>();
		ContatoDao<Contato> contatoDao = new ContatoDao<Contato>();
		Pessoa pessoa = (Pessoa) genericDAO.pesquisar(1L, Pessoa.class);
		
		Contato telefoneUser = new Contato();
		telefoneUser.setDdd(71);
		
		telefoneUser.setTipo("Empresarial");
		telefoneUser.setNumero("3397-5465");
		telefoneUser.setPessoa(pessoa);
		contatoDao.salvar(telefoneUser);
	}
	
	@Test
	public void salvarPessoa() throws SQLException{
		//DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<>();
		Pessoa pessoa = new Pessoa();
		PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
		
		pessoa.setNome("Pessoa2");
		pessoa.setEmail("@testes");
		pessoa.setSenha("@testes");
		pessoaDao.salvarPessoa(pessoa);
		
		
	}
	//Nao retorna
	@Test
	public void listarTodos(){
		//Pessoa pessoa = new Pessoa();
		PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
		List<Pessoa> list = pessoaDao.getListEntity(Pessoa.class);
		
		for(Pessoa pessoa : list) {
			System.out.println(pessoa);
			System.out.println();
		}
		
	}

}
