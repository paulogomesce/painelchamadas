import javax.persistence.EntityManager;

import br.com.painel.persistence.ConexaoFactory;


public class TesteLogin {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		EntityManager em = new ConexaoFactory().getConexao();
		//em.getTransaction().begin();
		//Query query = em.createQuery("select u from UsuarioSistema u where u.login = :login and u.senha = :senha");
		//query.setParameter("login", "paulo");
		//query.setParameter("senha", Criptografia.md5("91545117"));
		//UsuarioSistema usuario = (UsuarioSistema)query.getSingleResult();
		//System.out.println(usuario.getLogin()+" - "+usuario.getSenha());
	}

}
