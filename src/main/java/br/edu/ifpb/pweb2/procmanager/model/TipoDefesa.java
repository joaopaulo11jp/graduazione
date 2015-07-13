package br.edu.ifpb.pweb2.procmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoDefesa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	
		public TipoDefesa(int id, String descricao){
			this.id = id;
			this.descricao = descricao;
		}
		
		public TipoDefesa(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
