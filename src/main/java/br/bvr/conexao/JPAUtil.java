package br.bvr.conexao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * 
 * @author PedroMiquiles
 *
 *  
 */


public class JPAUtil {
	
	private static EntityManagerFactory factory;
	
	static {
		 
		if (factory == null) {
		
		factory = Persistence.createEntityManagerFactory("BVR-PU");
		
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager(); //persistencia
		
	}
	
	//metodo que identifica a chave primaria de um objeto
	public static Object getPrimaryKey (Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
	
	
		
	}
	
	


