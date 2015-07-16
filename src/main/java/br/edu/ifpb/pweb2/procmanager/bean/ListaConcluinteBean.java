package br.edu.ifpb.pweb2.procmanager.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;
import br.edu.ifpb.pweb2.procmanager.model.Concluinte;
import br.edu.ifpb.pweb2.procmanager.model.Usuario;


@ManagedBean
@RequestScoped
public class ListaConcluinteBean implements Serializable{
	private List<Concluinte> concluintes;
	private List<Concluinte> concluintesFiltered;
	
	
	@PostConstruct
	public void init(){
		this.concluintes = new DAOConcluinte().readAll();
		this.concluintesFiltered = new ArrayList<Concluinte>();
	}


	public List<Concluinte> getConcluintes() {
		return concluintes;
	}


	public void setConcluintes(List<Concluinte> concluintes) {
		this.concluintes = concluintes;
	}


	public List<Concluinte> getConcluintesFiltered() {
		return concluintesFiltered;
	}


	public void setConcluintesFiltered(List<Concluinte> concluintesFiltered) {
		this.concluintesFiltered = concluintesFiltered;
	}
	
	public void loadFlashConcluinte(Concluinte concluinte){
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			flash.put("concluinte",concluinte);
	}
	
	public String paginaMostraAluno(Concluinte concluinte){
		loadFlashConcluinte(concluinte);
		return "mostraAluno.jsf";
	}
	
	public String editarAluno(Concluinte concluinte){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("concluinte",concluinte);
		
		return "editarAluno.jsf";
	}
	
	public String excluir(Concluinte concluinte){
		DAOConcluinte daoC = new DAOConcluinte();
		
		daoC.begin();
		
		daoC.delete(daoC.read(concluinte.getMatricula()));
		
		daoC.commit();
		
		return "listarAluno.jsf?faces-redirect=true";
	}
	
	public List<Concluinte> getConcluintesComPendencias(){
		return new DAOConcluinte().readAllConcluiteWithPendencias();
	}
}
