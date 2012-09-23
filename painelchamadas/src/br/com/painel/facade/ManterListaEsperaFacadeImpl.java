package br.com.painel.facade;

import java.util.List;
import br.com.painel.domain.ListaEspera;
import br.com.painel.persistence.*;

public class ManterListaEsperaFacadeImpl implements ManterListaEsperaFacade{

	ManterListaEsperaDAO dao = new ManterListaEsperaDAOImpl(); 
	
	public boolean save(ListaEspera listaEspera) {
		return dao.save(listaEspera);
	}

	public boolean update(ListaEspera listaEspera) {
		return false;
	}

	public boolean delete(ListaEspera listaEspera) {
		return false;
	}

	public List<ListaEspera> listAll(ListaEspera listaEspera) {
		return null;
	}

	public List<ListaEspera> listById(ListaEspera listaEspera) {
		return null;
	}
}
