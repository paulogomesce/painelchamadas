package br.com.painel.managedBean;

import javax.faces.bean.ManagedBean;
import br.com.painel.domain.UsuarioSistema;
import br.com.painel.facade.ManterUsuarioSistema;
import br.com.painel.facade.ManterUsuarioSistemaImpl;
import br.com.painel.util.FacesMessageUtil;

@ManagedBean
public class LoginBean {
	
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String processaLogin(){
		
		String resultado = null;
		try{
		ManterUsuarioSistema objFacade = new ManterUsuarioSistemaImpl();
		UsuarioSistema usuario = new UsuarioSistema();
		usuario = objFacade.validaLogin(this.login, this.senha);
		if(usuario != null){
			resultado = "addCliFila";
		}
		}catch (Exception e) {
			FacesMessageUtil.addErro("Dados de acesso inválidos!");
		}

		return resultado;
	}
}
