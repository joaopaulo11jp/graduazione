package br.edu.ifpb.pweb2.procmanager.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;
import br.edu.ifpb.pweb2.procmanager.model.Anotacao;
import br.edu.ifpb.pweb2.procmanager.model.Concluinte;

@ManagedBean
@ViewScoped
public class MostraAlunoBean {
	private Concluinte concluinte;
	private String matricula;
	private String anotacao;
	
	@PostConstruct
	public void init(){
		
	}
	
	
	public void unloadFlashConcluinte(){
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			this.concluinte = (Concluinte) flash.get("concluinte");
		
	}

	public Concluinte getConcluinte() {
		return concluinte;
	}

	public void setConcluinte(Concluinte concluinte) {
		this.concluinte = concluinte;
	}

	
	public void carregaAluno(){
		System.out.println("Metodo Carrega aluno");
		if(this.concluinte == null) this.concluinte = new DAOConcluinte().read(this.matricula);
	}
	
	public void carregaAluno(String matricula,boolean editavel){
		
		this.concluinte = new DAOConcluinte().read(matricula);
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getAnotacao() {
		return anotacao;
	}


	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	public String registrarAnotacao(){
		System.out.println("ENTROU AQUI");
		if(this.anotacao != null){
			if(this.anotacao.length() != 0){
				DAOConcluinte daoC = new DAOConcluinte();
				daoC.begin();
				Concluinte concluinte = daoC.read(this.concluinte.getMatricula());
				System.out.println(concluinte.getAnotacoes());
				concluinte.getAnotacoes().add(new Anotacao(new Date(),this.anotacao));
				
				daoC.update(concluinte);
									
				daoC.commit();
			}
		}
		System.out.println("CHEGOU NO RETURN");
		return "mostraAluno.jsf?faces-redirect=true&matricula="+concluinte.getMatricula();
	}
	
}
