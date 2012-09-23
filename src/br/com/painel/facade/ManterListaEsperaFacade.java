package br.com.painel.facade;

import java.util.List;
import br.com.painel.domain.ListaEspera;

public interface ManterListaEsperaFacade {

	public boolean save(ListaEspera listaEspera);
	public boolean update(ListaEspera listaEspera);
	public boolean delete(ListaEspera listaEspera);
	public List<ListaEspera> listAll(ListaEspera listaEspera);
	public List<ListaEspera> listById(ListaEspera listaEspera);

}
