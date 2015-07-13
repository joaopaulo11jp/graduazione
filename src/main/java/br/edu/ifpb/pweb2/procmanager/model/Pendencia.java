package br.edu.ifpb.pweb2.procmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pendencia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean pendenciaSatisfeita;
	@OneToOne
    @JoinTable(name="Pendencia_Tipo", joinColumns={@JoinColumn(name="pendencia_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="tipo_id", referencedColumnName="id")})
	private TipoPendencia tipo;
	
		public Pendencia(int id, boolean pendenciaSatisfeita, TipoPendencia tipo) {
			this.id = id;
			this.pendenciaSatisfeita = pendenciaSatisfeita;
			this.tipo = tipo;
		}
		
		public Pendencia(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPendenciaSatisfeita() {
		return pendenciaSatisfeita;
	}

	public void setPendenciaSatisfeita(boolean pendenciaSatisfeita) {
		this.pendenciaSatisfeita = pendenciaSatisfeita;
	}

	public TipoPendencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoPendencia tipo) {
		this.tipo = tipo;
	}
	
		
}
