package br.sefaz.Dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import br.sefaz.conexao.JPAUtil;
import br.sefaz.entidades.Pessoa;
/**
 * @author Pedro Miquiles
 */
public class PessoaDao<E> extends DaoGeneric<Pessoa>{
	

	
	public void removerPeloID (Pessoa pessoa) throws Exception{
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
		Pessoa retornoPessoa = (Pessoa) entityManager.merge(pessoa);
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
	
	
	
	
	public List<Pessoa> listarTodos() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		javax.persistence.Query query = entityManager.createQuery("from pessoa");

		@SuppressWarnings("unchecked")
		List<Pessoa> pessoa = query.getResultList();

		return pessoa;

	}

	
	
	
	
	public List<Pessoa> pesquisarPorNome(String nome){
		EntityManager entityManager = JPAUtil.getEntityManager();
		return entityManager.createQuery("from pessoa where nome like :nome ", Pessoa.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}
	
	
	
	
		
	
}


