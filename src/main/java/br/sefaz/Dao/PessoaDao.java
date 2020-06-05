package br.sefaz.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.sefaz.entidades.Pessoa;
import br.sefaz.conexao.JPAUtil;

public class PessoaDao {
	
	
	public Pessoa update(Pessoa pessoa) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Abrindo a sess�o
		entityTransaction.begin();
		
		//Merge insere e retorna o objeto
		Pessoa retornoPessoa = entityManager.merge(pessoa);

		entityTransaction.commit();
		entityManager.close();

		return retornoPessoa;
		
		
	}

	public  Pessoa salvarPessoa(Pessoa pessoa) {
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Abrindo a sess�o
		entityTransaction.begin();
		
		//Merge insere e retorna o objeto
		Pessoa retornoPessoa = entityManager.merge(pessoa);

		entityTransaction.commit();
		entityManager.close();

		return retornoPessoa;
	}
	
	public static List<Pessoa> getListEntity(Class<Pessoa> pessoa){
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		List<Pessoa> pessoas = entityManager.createQuery("from pessoa").getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return pessoas;
		
	}
	
	
	public List<Pessoa> listarTodos() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		javax.persistence.Query query = entityManager.createQuery("from pessoa");

		List<Pessoa> pessoa = query.getResultList();

		return pessoa;

	}
	
		
		
	
}


