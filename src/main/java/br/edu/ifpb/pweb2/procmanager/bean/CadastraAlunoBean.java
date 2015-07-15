package br.edu.ifpb.pweb2.procmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;
import br.edu.ifpb.pweb2.procmanager.dao.DAOProfessor;
import br.edu.ifpb.pweb2.procmanager.dao.DAOTipoDefesa;
import br.edu.ifpb.pweb2.procmanager.model.Anotacao;
import br.edu.ifpb.pweb2.procmanager.model.Concluinte;
import br.edu.ifpb.pweb2.procmanager.model.Pendencia;
import br.edu.ifpb.pweb2.procmanager.model.Professor;
import br.edu.ifpb.pweb2.procmanager.model.TipoDefesa;


@ManagedBean
@RequestScoped
public class CadastraAlunoBean {
	private String matricula;
	private String nome;
	private double nota;
	private int tipo;
	private Map<String,Integer> tiposDefesa;
	private String tituloDefesa;
	private Date dataConclusao;
	private List<String> pendencias;
	private List<Professor> banca;
	private Map<String,Integer> professoresReg;
	private int orientador;
	private Date dataApresentacao;
	private int professorBanca1;
	private int professorBanca2;
	private int professorBanca3;
	
	
	@PostConstruct
	public void init(){
		List<Professor> prof = new DAOProfessor().readAll();
		List<TipoDefesa> tDefesa = new DAOTipoDefesa().readAll();
		if(prof.size() > 0){
			this.professoresReg = new HashMap<String,Integer>(); 
			for(Professor pfReg : prof){
				this.professoresReg.put(pfReg.getNome(),pfReg.getId());
			}
		}
		if(tDefesa.size() > 0){
			this.tiposDefesa = new HashMap<String,Integer>();
			for(TipoDefesa td:tDefesa){
				this.tiposDefesa.put(td.getDescricao(),td.getId());
			}
		}
		
	}
	
	
	
	public int getOrientador() {
		return orientador;
	}



	public void setOrientador(int orientador) {
		this.orientador = orientador;
	}



	public Map<String,Integer> getProfessoresReg() {
		return professoresReg;
	}
	public void setProfessoresReg(Map<String,Integer> professoresReg) {
		this.professoresReg = professoresReg;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getTituloDefesa() {
		return tituloDefesa;
	}
	public void setTituloDefesa(String tituloDefesa) {
		this.tituloDefesa = tituloDefesa;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public List<String> getPendencias() {
		return pendencias;
	}
	public void setPendencias(List<String> pendencias) {
		this.pendencias = pendencias;
	}
	public List<Professor> getBanca() {
		return banca;
	}
	public void setBanca(List<Professor> banca) {
		this.banca = banca;
	}



	public Date getDataApresentacao() {
		return dataApresentacao;
	}



	public void setDataApresentacao(Date dataApresentacao) {
		this.dataApresentacao = dataApresentacao;
	}



	public int getProfessorBanca1() {
		return professorBanca1;
	}



	public void setProfessorBanca1(int professorBanca1) {
		this.professorBanca1 = professorBanca1;
	}



	public int getProfessorBanca2() {
		return professorBanca2;
	}



	public void setProfessorBanca2(int professorBanca2) {
		this.professorBanca2 = professorBanca2;
	}



	public int getProfessorBanca3() {
		return professorBanca3;
	}



	public void setProfessorBanca3(int professorBanca3) {
		this.professorBanca3 = professorBanca3;
	}
		
	
	
	
	public Map<String, Integer> getTiposDefesa() {
		return tiposDefesa;
	}



	public void setTiposDefesa(Map<String, Integer> tiposDefesa) {
		this.tiposDefesa = tiposDefesa;
	}



	public String registrar(){
		System.out.println("ENTROU NO REGISTRAR!");
		DAOProfessor pDao = new DAOProfessor();
		System.out.println("1");
		List<Professor> professoresSelecionados = new ArrayList<Professor>();
		System.out.println("1");
		professoresSelecionados.add(pDao.read(this.professorBanca1));
		System.out.println("1");
		professoresSelecionados.add(pDao.read(this.professorBanca2));
		System.out.println("1");
		professoresSelecionados.add(pDao.read(this.professorBanca3));
		System.out.println("1");
		
		System.out.println("1");
		Concluinte c = new Concluinte(this.matricula,
				this.nome,
				professoresSelecionados,
				(TipoDefesa) new DAOTipoDefesa().
				read(this.tipo),
				this.tituloDefesa,
				this.nota,null,
				new ArrayList<Anotacao>(),
				new ArrayList<Pendencia>(),
				null,this.dataApresentacao,
				pDao.read(this.orientador));
		System.out.println("1");
		DAOConcluinte daoC = new DAOConcluinte();
		System.out.println("1");
		daoC.begin();
		System.out.println("1");
		daoC.create(c);
		System.out.println("1");
		daoC.commit();
		System.out.println("1");
		System.out.println("2");
		//System.out.println(daoC.readById("20131370060").getNome());
		System.out.println("1");
		this.addMessage("Concluinte cadastrado", "Concluinte cadastrado!");
		System.out.println("50");
        return "boasVindas.jsf";
	}
	
	public void addMessage(String summary, String detail){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
