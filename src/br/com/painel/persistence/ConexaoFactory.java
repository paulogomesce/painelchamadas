package br.com.painel.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory {
	
	private EntityManager manager;

	public EntityManager getConexao(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PAINAL_CHAMADAS");
		this.manager = factory.createEntityManager();
		return this.manager;
	}
	
	public void fechaConexao(){
		this.manager.close();
	}
}
