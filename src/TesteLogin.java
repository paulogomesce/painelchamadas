import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.painel.domain.UsuarioSistema;
import br.com.painel.persistence.ConexaoFactory;
import br.com.painel.persistence.ManterListaEsperaDAO;
import br.com.painel.persistence.ManterListaEsperaDAOImpl;
import br.com.painel.util.Criptografia;


public class TesteLogin {

	public static void main(String[] args) {

		EntityManager em = ConexaoFactory.getConexao();
		//em.getTransaction().begin();
		//Query query = em.createQuery("select u from UsuarioSistema u where u.login = :login and u.senha = :senha");
		//query.setParameter("login", "paulo");
		//query.setParameter("senha", Criptografia.md5("91545117"));
		//UsuarioSistema usuario = (UsuarioSistema)query.getSingleResult();
		//System.out.println(usuario.getLogin()+" - "+usuario.getSenha());
	}

}
