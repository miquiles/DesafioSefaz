package br.sefaz.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.sefaz.conexao.JPAUtil;
import br.sefaz.entidades.Pessoa;
/**
 * @author Pedro Miquiles
 */


public class DaoGeneric<E> {
	
	private EntityManager entityManager = JPAUtil.getEntityManager();

	
	public E pesquisar(Long id, Class<E> entidade) {
		//limpar o que está em memoria e trazer apenas registros no banco.
		entityManager.clear();
		
		E e = (E) entityManager.find(entidade, id);
		//E e = (E) entityManager.createQuery("from " + entidade.getSimpleName() + " where id = " + id).getSingleResult();
		return e;
	}
	
	
	
	
	
	
	
	
	public E salvar(E entidade) throws Exception{
		
		
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Abrindo a sessão
		entityTransaction.begin();
		
		//Merge insere e retorna o objeto
		E e = entityManager.merge(entidade);

		entityTransaction.commit();
		entityManager.close();

		return e;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	
	
	
}
