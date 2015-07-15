package br.edu.ifpb.pweb2.procmanager.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProcessoEstagio {
	@Id
	private Long protocolo;
	private Date dataAbertura;
	private Date dataChegada;
	@OneToOne
	private Situacao situacao;
	@OneToOne
	private Concluinte concluinte;
	
		public ProcessoEstagio(Long protocolo, Professor orientador,
				Date dataAbertura, Date dataChegada, Situacao situacao) {
			this.protocolo = protocolo;
			this.dataAbertura = dataAbertura;
			this.dataChegada = dataChegada;
			this.situacao = situacao;
		}
		
		public ProcessoEstagio(){}

	public Long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Long protocolo) {
		this.protocolo = protocolo;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Concluinte getConcluinte() {
		return concluinte;
	}

	public void setConcluinte(Concluinte concluinte) {
		this.concluinte = concluinte;
	}
	
}
