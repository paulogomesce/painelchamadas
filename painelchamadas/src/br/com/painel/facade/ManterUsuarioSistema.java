package br.com.painel.facade;

import java.util.List;

import br.com.painel.domain.UsuarioSistema;

public interface ManterUsuarioSistema {
	public boolean save(UsuarioSistema usuarioSistema);
	public boolean update(UsuarioSistema usuarioSistema);
	public boolean delete(UsuarioSistema usuarioSistema);
	public List<UsuarioSistema> listAll(UsuarioSistema usuarioSistema);
	public List<UsuarioSistema> listById(UsuarioSistema usuarioSistema);
	public UsuarioSistema validaLogin(String login, String senha);

}
