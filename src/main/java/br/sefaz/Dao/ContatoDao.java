package br.sefaz.Dao;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.sefaz.conexao.JPAUtil;
import br.sefaz.entidades.Contato;


/**
 * @author Pedro Miquiles
 */

public class ContatoDao<E> extends DaoGeneric<Contato> {
	
	
	@SuppressWarnings("unchecked")
	public List<Contato> listarTodos() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		javax.persistence.Query query = entityManager.createQuery("from contato");

		List<Contato> contatos = query.getResultList();

		return contatos;

	}
	
	
	public void removerPeloID (Contato contato) throws Exception{
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		//esse objeto retornará o id. Metodo criado em JPAUtil
		Object id = JPAUtil.getPrimaryKey(contato);
		entityManager.createNativeQuery("delete from contato where id="+id).executeUpdate();
		
	
		
		entityTransaction.commit();
		entityManager.close();
		
		
	}
	

}
