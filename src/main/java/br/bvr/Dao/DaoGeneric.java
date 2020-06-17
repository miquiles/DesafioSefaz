package br.bvr.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.bvr.conexao.JPAUtil;


public class DaoGeneric<E> {
	
	EntityManager entityManager = JPAUtil.getEntityManager();

	
	public E pesquisar(Long id, Class<E> entidade) {
		
		entityManager.clear();
		E e = (E) entityManager.find(entidade, id);
		return e;
	}
	
	public E pesquisar(E entidade) {
		Object id = JPAUtil.getPrimaryKey(entidade);
		@SuppressWarnings("unchecked")
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;
	}
	
	
	
public E salvar(E entidade) {
		
		
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Abrindo a sessão
		entityTransaction.begin();
		
		//Merge insere e retorna o objeto
		E e = entityManager.merge(entidade);

		entityTransaction.commit();
		entityManager.close();

		return e;
	}



	
}
