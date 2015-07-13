package br.edu.ifpb.pweb2.procmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anotacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dataCriacao;
	private String anotacao;
	
		public Anotacao(int id,Date dataCriacao,String anotacao){
			this.id = id;
			this.dataCriacao = dataCriacao;
			this.anotacao = anotacao;
		}

		public Anotacao(){}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
	
}
