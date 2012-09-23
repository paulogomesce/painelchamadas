package br.com.painel.facade;

import java.util.List;


import br.com.painel.domain.UsuarioSistema;
import br.com.painel.persistence.UsuarioSistemaDAO;
import br.com.painel.persistence.UsuarioSistemaDAOImpl;

public class ManterUsuarioSistemaImpl implements ManterUsuarioSistema{

	@Override
	public boolean save(UsuarioSistema usuarioSistema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UsuarioSistema usuarioSistema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UsuarioSistema usuarioSistema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UsuarioSistema> listAll(UsuarioSistema usuarioSistema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioSistema> listById(UsuarioSistema usuarioSistema) {
		return null;
	}

	@Override
	public UsuarioSistema validaLogin(String login, String senha) {
		
		UsuarioSistemaDAO usuarioTemp = new UsuarioSistemaDAOImpl();
		return usuarioTemp.validaLogin(login, senha);
		
	}

}
