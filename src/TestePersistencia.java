import java.math.BigDecimal;

import br.com.painel.domain.ListaEspera;
import br.com.painel.facade.ManterListaEsperaFacade;
import br.com.painel.facade.ManterListaEsperaFacadeImpl;

public class TestePersistencia {
	public static void main(String[] args) {
		
		
		ListaEspera t = new ListaEspera();
		int senha = 1;
		t.setNmCliente("Adejanny Feitosa");
		t.setCdSenha(null);
		t.setCdStutus(0);
		t.setNmUsuarioStatus("SISTEMA_AUTOMATICO");
		t.setDataHoraInclusao(null);

		ManterListaEsperaFacade objPersistencia = new ManterListaEsperaFacadeImpl();
		objPersistencia.save(t);
		
	}

}
