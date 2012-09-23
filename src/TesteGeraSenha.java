import br.com.painel.domain.ListaEspera;
import br.com.painel.persistence.ManterListaEsperaDAO;
import br.com.painel.persistence.ManterListaEsperaDAOImpl;


public class TesteGeraSenha {

	public static void main(String[] args) {

		ManterListaEsperaDAO listaEspera = new ManterListaEsperaDAOImpl();
		
		//System.out.println(listaEspera.obterSenha());
		
		for (ListaEspera lista : listaEspera.chamaProximoDaFila()) {
			System.out.println(lista.getCdSenha() + " - " +lista.getNmCliente());
		}
	}

}
