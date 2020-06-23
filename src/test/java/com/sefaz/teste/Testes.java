package com.sefaz.teste;

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
	public void testGravarTelefone() throws Exception {
		DaoGeneric<Pessoa> genericDAO = new DaoGeneric<Pessoa>();
		ContatoDao<Contato> contatoDao = new ContatoDao<Contato>();
		Pessoa pessoa = (Pessoa) genericDAO.pesquisar(1L, Pessoa.class);
		
		Contato telefoneUser = new Contato();
		telefoneUser.setDdd(71);
		
		
		telefoneUser.setTipo("TesteEmpresarial");
		telefoneUser.setNumero("Teste3397-5465");
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
	
	@Test
	public void listarTodos(){
		//Pessoa pessoa = new Pessoa();
		PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
		
		List<Pessoa> list = pessoaDao.listarTodos();

		for(Pessoa pessoa : list) {
			System.out.println(pessoa.getNome());
			System.out.println(pessoa.getEmail());
			System.out.println(pessoa.getSenha());
			System.out.println("---------");
		}
		
		
		
	}
	
	@Test
	public void listarTelefones() {
		ContatoDao<Contato> contatoDao = new ContatoDao<>();
		List<Contato> listTelefones =  contatoDao.listarTodos();
		
		for(Contato contato : listTelefones ) {
			System.out.println(contato.getDdd());
			System.out.println(contato.getTipo());
			System.out.println(contato.getNumero());
			System.out.println(contato.getPessoa());
			System.out.println("------------------");
			
		}
	}
	
	
	//Editando um registro e retornando o mesmo já editado.
	@Test
	public void atualizarPessoa() {
		PessoaDao<Pessoa> pessoaDao = new PessoaDao<>();
		Pessoa pessoa = new Pessoa();
		
		
		
		pessoa.setId(41L);
		pessoa.setNome("usuarioEditado");
		pessoa.setEmail("Email editado");
		pessoa.setSenha("senhaeditada");
		System.out.println();
		
		pessoaDao.update(pessoa);
		//irá pesquisar no banco o id acima editado. Retornará o registro editado.
		Pessoa pessoaEditada = (Pessoa) pessoaDao.pesquisar(41L, Pessoa.class);
		System.out.println(pessoaEditada.getId());
		
		System.out.println(pessoaEditada.getNome());
		System.out.println(pessoaEditada.getEmail());
		System.out.println(pessoaEditada.getSenha());
		System.out.println("---------");
		
		
	}
	
		
				
			
					
		
	
}
