package br.sefaz.Dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.sefaz.conexao.JPAUtil;
import br.sefaz.entidades.Contato;
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

	
	public List<Contato> todos(){
		
		//return this.entityManager.createQuery("from Contato c join fetch c.pessoa",Contato.class).getResultList();
	
		
		
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Contato> criteriaQuery = builder.createQuery(Contato.class);
		
		Root<Contato> contato = criteriaQuery.from(Contato.class);
		criteriaQuery.select(contato);
		
		TypedQuery<Contato> query = this.entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
public E update(E entidade) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Abrindo a sessão
		entityTransaction.begin();
		
		//Merge atualiza se receber um id do objeto
		E e = (E) entityManager.merge(entidade);
		entityTransaction.commit();
		entityManager.close();
		

		return e;
		
		
	}
	
	
}
