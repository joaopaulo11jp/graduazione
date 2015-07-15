package br.edu.ifpb.pweb2.procmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPendencia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricaoPendencia;
	private boolean obrigatoria;
	
		public TipoPendencia(int id, String descricaoPendencia) {
			this.id = id;
			this.descricaoPendencia = descricaoPendencia;
		}
		
		public TipoPendencia(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricaoPendencia() {
		return descricaoPendencia;
	}

	public void setDescricaoPendencia(String descricaoPendencia) {
		this.descricaoPendencia = descricaoPendencia;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}

	public void setObrigatoria(boolean obrigatoria) {
		this.obrigatoria = obrigatoria;
	}
	

}
