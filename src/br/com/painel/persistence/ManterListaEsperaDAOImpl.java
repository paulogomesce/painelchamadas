package br.com.painel.persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.painel.domain.ListaEspera;

public class ManterListaEsperaDAOImpl implements ManterListaEsperaDAO{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PAINAL_CHAMADAS");
	EntityManager em = factory.createEntityManager();
	
	@Override
	public boolean save(ListaEspera listaEspera) {
		boolean resultado = false;
		try{
			em.getTransaction().begin();
			listaEspera.setDataHoraInclusao(new Date());
			listaEspera.setCdSenha(obterSenha());
			em.persist(listaEspera);
			em.getTransaction().commit();
			em.close();
			resultado = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean update(ListaEspera listaEspera) {
		return false;
	}

	@Override
	public boolean delete(ListaEspera listaEspera) {
		return false;
	}

	@Override
	public List<ListaEspera> listAll(ListaEspera listaEspera) {
		return null;
	}

	@Override
	public List<ListaEspera> listById(ListaEspera listaEspera) {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListaEspera> chamaProximoDaFila(){
		ConexaoFactory manager = new ConexaoFactory();
		List<ListaEspera> proximoDaFila;
		Query query = manager.getConexao().createQuery("select le from ListaEspera le where le.cdStutus = 0 order by le.cdSenha", ListaEspera.class).setMaxResults(1);
		proximoDaFila = query.getResultList();
		manager.fechaConexao();
		return proximoDaFila;  
	}
	
	public BigDecimal obterSenha(){
		EntityManager manager = new ConexaoFactory().getConexao();
		BigDecimal cdSenha = null;
		try{
			Query query = manager.createNativeQuery("select to_number(nextval('painel.seq_cd_senha')||'', '9999999999')");
			cdSenha = (BigDecimal) query.getSingleResult();
			manager.close();			
		}catch (Exception e) {
			//FacesMessageUtil.addErro("Erro na gera��o da senha.");
			System.out.println(e.toString());
		}
		return cdSenha;
	}

}
