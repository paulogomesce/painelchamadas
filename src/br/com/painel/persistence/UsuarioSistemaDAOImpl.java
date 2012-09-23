package br.com.painel.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.painel.domain.UsuarioSistema;
import br.com.painel.util.Criptografia;

public class UsuarioSistemaDAOImpl implements UsuarioSistemaDAO{
	
	public boolean save(UsuarioSistema usuarioSistema){
		boolean resultado = false;
		EntityManager em = ConexaoFactory.getConexao();
		em.getTransaction().begin();
		em.persist(usuarioSistema);
		em.getTransaction().commit();
		em.close();
		return resultado;
	}	
	
	public boolean update(UsuarioSistema usuarioSistema){
		return false;
	}
	public boolean delete(UsuarioSistema usuarioSistema){
		return false;
	}
	public List<UsuarioSistema> listAll(UsuarioSistema usuarioSistema){
		return null;
	}
	public List<UsuarioSistema> listById(UsuarioSistema usuarioSistema){
		return null;
	}	

	public UsuarioSistema validaLogin(String login, String senha){
		EntityManager em = ConexaoFactory.getConexao();
		em.getTransaction().begin();
		Query query = em.createQuery("select u from UsuarioSistema u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", Criptografia.md5(senha));
		UsuarioSistema usuario = (UsuarioSistema)query.getSingleResult();
		return usuario;
	}
}
