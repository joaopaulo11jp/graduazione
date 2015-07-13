package br.edu.ifpb.pweb2.procmanager.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Concluinte {
	@Id
	private Long matricula;
	private String nome;
	@OneToMany
    @JoinTable(name="Concluinte_Banca", joinColumns={@JoinColumn(name="concluinte_id", referencedColumnName="matricula")}, inverseJoinColumns={@JoinColumn(name="professor_id", referencedColumnName="id")})
	private List<Professor> banca;
	@OneToOne
	@PrimaryKeyJoinColumn
	private TipoDefesa tipo;
	private String tituloDefesa;
	private double nota;
	@OneToOne
	@PrimaryKeyJoinColumn
	private ProcessoEstagio processoEstagio;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="concluinte_id")
	private List<Anotacao> anotacoes;
	@OneToMany
	@JoinColumn(name="concluinte_id")
	private List<Pendencia> pendencias;
	private Date dataConclusao;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="concluinte_id")
	private List<Historico> conjuntoHistorico;
	
		public Concluinte(Long matricula, String nome, List<Professor> banca,
			TipoDefesa tipo, String tituloDefesa, double nota,
			ProcessoEstagio processoEstagio, List<Anotacao> anotacoes,
			List<Pendencia> pendencias, Date dataConclusao) {
		
			this.matricula = matricula;
			this.nome = nome;
			this.banca = banca;
			this.tipo = tipo;
			this.tituloDefesa = tituloDefesa;
			this.nota = nota;
			this.processoEstagio = processoEstagio;
			this.anotacoes = anotacoes;
			this.pendencias = pendencias;
			this.dataConclusao = dataConclusao;
		}
		
		public Concluinte(){}

	public Long getMatricula() {
		return matricula;
	}

	public void setId(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Professor> getBanca() {
		return banca;
	}

	public void setBanca(List<Professor> banca) {
		this.banca = banca;
	}

	public TipoDefesa getTipo() {
		return tipo;
	}

	public void setTipo(TipoDefesa tipo) {
		this.tipo = tipo;
	}

	public String getTituloDefesa() {
		return tituloDefesa;
	}

	public void setTituloDefesa(String tituloDefesa) {
		this.tituloDefesa = tituloDefesa;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public ProcessoEstagio getProcessoEstagio() {
		return processoEstagio;
	}

	public void setProcessoEstagio(ProcessoEstagio processoEstagio) {
		this.processoEstagio = processoEstagio;
	}

	public List<Anotacao> getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(List<Anotacao> anotacoes) {
		this.anotacoes = anotacoes;
	}

	public List<Pendencia> getPendencias() {
		return pendencias;
	}

	public void setPendencias(List<Pendencia> pendencias) {
		this.pendencias = pendencias;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public List<Historico> getConjuntoHistorico() {
		return conjuntoHistorico;
	}

	public void setConjuntoHistorico(List<Historico> conjuntoHistorico) {
		this.conjuntoHistorico = conjuntoHistorico;
	}
	
}
