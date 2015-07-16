package br.edu.ifpb.pweb2.procmanager.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifpb.pweb2.procmanager.model.Professor;

@ManagedBean
@RequestScoped
public class ListaProfessores {
	public List<Professor> professores;

	
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	
	
} 
