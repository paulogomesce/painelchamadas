package br.com.painel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.painel.util.Criptografia;

@Entity
@Table(name = "painel.tb_usuario")
public class UsuarioSistema {
	
	private Integer id;
	private String login;
	private String senha;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "painel.seq_id_usuario_sistema")
	@SequenceGenerator(name = "painel.seq_id_usuario_sistema", sequenceName = "painel.seq_id_usuario_sistema", allocationSize = 1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
		this.senha = Criptografia.md5(senha);//Criptografa a senha em md5
	}
	
	
	
}
