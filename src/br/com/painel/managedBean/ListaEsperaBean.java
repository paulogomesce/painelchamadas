package br.com.painel.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.painel.domain.ListaEspera;
import br.com.painel.facade.ManterListaEsperaFacade;
import br.com.painel.facade.ManterListaEsperaFacadeImpl;

@ManagedBean
@RequestScoped
public class ListaEsperaBean {

	ManterListaEsperaFacade objPersistencia;
	private ListaEspera listaEspera;
	private boolean botaoNovo, botaoSalvar;
	//private Date dataInclusaoFila; 
	
	public ListaEsperaBean(){
		objPersistencia = new ManterListaEsperaFacadeImpl();
		listaEspera     = new ListaEspera();
		listaEspera.setNmCliente(null);
		listaEspera.setCdSenha(null);
		listaEspera.setCdStutus(0);
		listaEspera.setNmUsuarioStatus("SISTEMA_AUTOMATICO");
		listaEspera.setDataHoraInclusao(null);
		botaoNovo   = false;
		botaoSalvar = false;		
	}

	public ListaEspera getListaEspera() {
		return listaEspera;
	}

	public void setListaEspera(ListaEspera listaEspera) {
		this.listaEspera = listaEspera;
	}
	
	public void save(){
		objPersistencia.save(listaEspera);
		botaoSalvar = true;
		
	}

	public void addNovo(){
		listaEspera = null;
		botaoSalvar = false;
		botaoNovo   = true;
	}

	
	public boolean isBotaoNovo() {
		return botaoNovo;
	}

	public void setBotaoNovo(boolean botaoNovo) {
		this.botaoNovo = botaoNovo;
	}

	public boolean isBotaoSalvar() {
		return botaoSalvar;
	}

	public void setBotaoSalvar(boolean botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}
	
	
	
}
