package br.com.painel.managedBean;

import javax.faces.bean.ManagedBean;
import br.com.painel.domain.UsuarioSistema;


@ManagedBean
public class UsuarioSistemaBean {
	
	private UsuarioSistema usuario;
	private String confirmaSenha;
	
	public UsuarioSistemaBean(){
		usuario = new UsuarioSistema();
	}

	public UsuarioSistema getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSistema usuario) {
		this.usuario = usuario;
	}
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public void salvar(){
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getLogin());
		System.out.println(this.confirmaSenha);
	}
	


}
