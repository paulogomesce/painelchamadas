package br.com.painel.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="painel.tb_lista_espera")
public class ListaEspera {
	
	private Integer cdAgendamento;
	private String  nmCliente;
	private BigDecimal cdSenha;
	private Date    dataHoraInclusao;
	private Integer cdStutus;
	private Date    dtMudancaStatus;
	private String  nmUsuarioStatus;
	
	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "painel.seq_cd_agendamento")
	@SequenceGenerator(name = "painel.seq_cd_agendamento", sequenceName = "painel.seq_cd_agendamento", allocationSize = 1)
	@Column(name = "cd_agendamento")
	public Integer getCdAgendamento() {
		return cdAgendamento;
	}	
	public void setCdAgendamento(Integer cdAgendamento) {
		this.cdAgendamento = cdAgendamento;
	}
	
	@Column(name = "nm_cliente")
	public String getNmCliente() {
		return nmCliente;
	}	
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	
	@Column(name = "cd_senha")
	public BigDecimal getCdSenha() {
		return cdSenha;
	}	
	public void setCdSenha(BigDecimal cdSenha) {
		this.cdSenha = cdSenha;
	}
	
	@Column(name = "data_hora_inclusao")
	public Date getDataHoraInclusao() {
		return dataHoraInclusao;
	}	
	public void setDataHoraInclusao(Date dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}
	
	@Column(name = "cd_stutus")
	public Integer getCdStutus() {
		return cdStutus;
	}	
	public void setCdStutus(Integer cdStutus) {
		this.cdStutus = cdStutus;
	}
	
	@Column(name = "dt_mudanca_status")
	public Date getDtMudancaStatus() {
		return dtMudancaStatus;
	}	
	public void setDtMudancaStatus(Date dtMudancaStatus) {
		this.dtMudancaStatus = dtMudancaStatus;
	}
	
	@Column(name = "nm_usuario_status")
	public String getNmUsuarioStatus() {
		return nmUsuarioStatus;
	}	
	public void setNmUsuarioStatus(String nmUsuarioStatus) {
		this.nmUsuarioStatus = nmUsuarioStatus;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cdAgendamento == null) ? 0 : cdAgendamento.hashCode());
		result = prime * result + ((cdSenha == null) ? 0 : cdSenha.hashCode());
		result = prime * result
				+ ((cdStutus == null) ? 0 : cdStutus.hashCode());
		result = prime
				* result
				+ ((dataHoraInclusao == null) ? 0 : dataHoraInclusao.hashCode());
		result = prime * result
				+ ((dtMudancaStatus == null) ? 0 : dtMudancaStatus.hashCode());
		result = prime * result
				+ ((nmCliente == null) ? 0 : nmCliente.hashCode());
		result = prime * result
				+ ((nmUsuarioStatus == null) ? 0 : nmUsuarioStatus.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaEspera other = (ListaEspera) obj;
		if (cdAgendamento == null) {
			if (other.cdAgendamento != null)
				return false;
		} else if (!cdAgendamento.equals(other.cdAgendamento))
			return false;
		if (cdSenha == null) {
			if (other.cdSenha != null)
				return false;
		} else if (!cdSenha.equals(other.cdSenha))
			return false;
		if (cdStutus == null) {
			if (other.cdStutus != null)
				return false;
		} else if (!cdStutus.equals(other.cdStutus))
			return false;
		if (dataHoraInclusao == null) {
			if (other.dataHoraInclusao != null)
				return false;
		} else if (!dataHoraInclusao.equals(other.dataHoraInclusao))
			return false;
		if (dtMudancaStatus == null) {
			if (other.dtMudancaStatus != null)
				return false;
		} else if (!dtMudancaStatus.equals(other.dtMudancaStatus))
			return false;
		if (nmCliente == null) {
			if (other.nmCliente != null)
				return false;
		} else if (!nmCliente.equals(other.nmCliente))
			return false;
		if (nmUsuarioStatus == null) {
			if (other.nmUsuarioStatus != null)
				return false;
		} else if (!nmUsuarioStatus.equals(other.nmUsuarioStatus))
			return false;
		return true;
	}	
}
