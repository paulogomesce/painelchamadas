package br.com.painel.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory {

	public static EntityManager getConexao(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PAINAL_CHAMADAS");
		EntityManager em = factory.createEntityManager();
		return em;
	}
}
