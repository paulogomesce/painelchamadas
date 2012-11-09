import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.painel.domain.ListaEspera;
import br.com.painel.domain.UsuarioSistema;
import br.com.painel.persistence.ManterListaEsperaDAO;
import br.com.painel.persistence.ManterListaEsperaDAOImpl;


public class TesteGeraSenha {

	public static void main(String[] args) {

		ManterListaEsperaDAO listaEspera = new ManterListaEsperaDAOImpl();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PAINAL_CHAMADAS");
		EntityManager em = factory.createEntityManager();
		
		System.out.println(listaEspera.obterSenha());
		
		Query query = em.createQuery("select u from UsuarioSistema u", UsuarioSistema.class);
		@SuppressWarnings("unchecked")
		List<UsuarioSistema> usuarios = query.getResultList();
		
		for (UsuarioSistema u : usuarios) {
			System.out.println(u.getLogin());
		}
		
		for (ListaEspera lista : listaEspera.chamaProximoDaFila()) {
			System.out.println(lista.getCdSenha() + " - " +lista.getNmCliente());
		}
	}

}
