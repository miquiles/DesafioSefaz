package br.sefaz.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.sefaz.conexao.JPAUtil;
import br.sefaz.entidades.Contato;


public class ContatoDao {
	
public  Contato salvarContato(Contato contato) {
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Abrindo a sessão
		entityTransaction.begin();
		
		//Merge insere e retorna o objeto
		Contato retornoContato = entityManager.merge(contato);

		entityTransaction.commit();
		entityManager.close();

		return retornoContato;
	}

}
