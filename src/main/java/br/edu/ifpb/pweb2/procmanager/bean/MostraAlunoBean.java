package br.edu.ifpb.pweb2.procmanager.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;
import br.edu.ifpb.pweb2.procmanager.model.Concluinte;

@ManagedBean
@ViewScoped
public class MostraAlunoBean {
	private Concluinte concluinte;
	private String mat;
	
	
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

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}
	
	public void carregaAluno(){
		this.concluinte = new DAOConcluinte().read(mat);
	}
	
	
}
