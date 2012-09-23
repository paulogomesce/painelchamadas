package br.com.painel.persistence;

import java.math.BigDecimal;
import java.util.List;
import br.com.painel.domain.ListaEspera;

public interface ManterListaEsperaDAO {

	public boolean save(ListaEspera listaEspera);
	public boolean update(ListaEspera listaEspera);
	public boolean delete(ListaEspera listaEspera);
	public List<ListaEspera> listAll(ListaEspera listaEspera);
	public List<ListaEspera> listById(ListaEspera listaEspera);
	public List<ListaEspera> chamaProximoDaFila();
	public BigDecimal obterSenha();
}