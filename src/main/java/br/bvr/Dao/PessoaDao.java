package br.bvr.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.bvr.conexao.JPAUtil;
import br.bvr.entidades.Pessoa;

public class PessoaDao<E> extends DaoGeneric<Pessoa>{
	
	

	
	
	public void removerPeloID (Pessoa pessoa) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		//esse objeto retornará o id. Metodo criado em JPAUtil
		Object id = JPAUtil.getPrimaryKey(pessoa);
		entityManager.createNativeQuery("delete from pessoa where id="+id).executeUpdate();
		
	
		
		entityTransaction.commit();
		entityManager.close();
		
		
	}
	
	

	
	
	
	public Pessoa update(Pessoa pessoa) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Abrindo a sessão
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
		
		//Abrindo a sessão
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
	
	public List<Pessoa> pesquisarId(Pessoa pessoa) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		
		javax.persistence.Query query = entityManager.createQuery("from pessoa where id =" + pessoa.getId());

		List<Pessoa> id = query.getResultList();

		return id;

	}
	
	public Long pesquisarCodigo(Long id) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		
		javax.persistence.Query query = entityManager.createQuery("from pessoa where id =" + id);

		
		
		return id;
		

	}
	
	
	
	
		
	
}


