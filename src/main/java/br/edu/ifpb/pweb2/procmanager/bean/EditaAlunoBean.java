package br.edu.ifpb.pweb2.procmanager.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;
import br.edu.ifpb.pweb2.procmanager.dao.DAOProfessor;
import br.edu.ifpb.pweb2.procmanager.dao.DAOTipoDefesa;
import br.edu.ifpb.pweb2.procmanager.model.Concluinte;
import br.edu.ifpb.pweb2.procmanager.model.Professor;
import br.edu.ifpb.pweb2.procmanager.model.TipoDefesa;



@ManagedBean
@ViewScoped
public class EditaAlunoBean {
	private Concluinte concluinte;
	private String matricula;
	private Map<String,Integer> professoresReg;
	private Map<String,Integer> tiposDefesa;
	private int tipo;
	private int orientador;
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
	
	
	
	public Concluinte getConcluinte() {
		return concluinte;
	}
	public void setConcluinte(Concluinte concluinte) {
		this.concluinte = concluinte;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void carregaAluno(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		this.concluinte = (Concluinte) flash.get("concluinte");
		
		this.professorBanca1 = this.concluinte.getBanca().get(0).getId();
		this.professorBanca2 = this.concluinte.getBanca().get(1).getId();
		this.professorBanca3 = this.concluinte.getBanca().get(2).getId();
		
		this.tipo = this.concluinte.getTipo().getId();
		this.orientador = this.concluinte.getOrientador().getId();
		
		//this.concluinte = new DAOConcluinte().read(matricula);
	}
	
	public String atualizarAluno(){
		
		System.out.println("ID concluinte"+this.concluinte.getMatricula());
		
		DAOConcluinte daoC = new DAOConcluinte();
		Concluinte concluinte;
		daoC.begin();
		
		concluinte = daoC.read(this.concluinte.getMatricula());
		concluinte.setNome(this.concluinte.getNome());
		concluinte.setOrientador(new DAOProfessor().read(this.orientador));
		concluinte.setNota(this.concluinte.getNota());
		concluinte.setTituloDefesa(this.concluinte.getTituloDefesa());
		concluinte.setDataApresentacao(this.concluinte.getDataApresentacao());
		concluinte.setBanca(this.concluinte.getBanca());
		concluinte.setTipo(new DAOTipoDefesa().read(this.tipo));
		
		daoC.update(concluinte);
		
		daoC.commit();
		
	    this.addMessage("Sucesso","Registro alterado!")	;
		
		return "listarAluno.jsf?faces-redirect=true";
	}

	
	public void addMessage(String summary, String detail){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Map<String, Integer> getProfessoresReg() {
		return professoresReg;
	}



	public void setProfessoresReg(Map<String, Integer> professoresReg) {
		this.professoresReg = professoresReg;
	}



	public Map<String, Integer> getTiposDefesa() {
		return tiposDefesa;
	}



	public void setTiposDefesa(Map<String, Integer> tiposDefesa) {
		this.tiposDefesa = tiposDefesa;
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



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public int getOrientador() {
		return orientador;
	}



	public void setOrientador(int orientador) {
		this.orientador = orientador;
	}
}
