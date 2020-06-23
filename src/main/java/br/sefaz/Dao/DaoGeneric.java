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

	
	public List<Pessoa> relatorioPessoaTelefone(){
		
		EntityManager entityManager = JPAUtil.getEntityManager();

		String sql = "select p.nome, c.ddd, c.tipo, c.numero from pessoa p INNER JOIN contato c on p.id = c.pessoa_id";
		javax.persistence.Query query = entityManager.createNativeQuery(sql);

		List<Pessoa> lista = query.getResultList();

		return lista;

		
	}
	
	
}
