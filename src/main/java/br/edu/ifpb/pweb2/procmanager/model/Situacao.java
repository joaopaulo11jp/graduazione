package br.edu.ifpb.pweb2.procmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Situacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricaoSituacao;
	private int ordem;
	
		public Situacao(int id, String descricaoSituacao, int ordem) {
			this.id = id;
			this.descricaoSituacao = descricaoSituacao;
			this.ordem = ordem;
		}
		
		public Situacao(){}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricaoSituacao() {
		return descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = descricaoSituacao;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
		
		
}
