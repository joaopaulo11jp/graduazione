package br.edu.ifpb.pweb2.procmanager.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifpb.pweb2.procmanager.dao.DAOProfessor;
import br.edu.ifpb.pweb2.procmanager.model.Professor;

@ManagedBean
@RequestScoped
public class ListaProfessoresBean {
	public List<Professor> professores;
	public String nome;
	
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public void carregaProfessores(){
		this.professores = new DAOProfessor().readAll();
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String registrar(){
		System.out.println(this.nome);
		DAOProfessor daoP = new DAOProfessor();
		daoP.begin();
		
		daoP.create(new Professor(this.nome));
		
		daoP.commit();
		
		return "listaProfessores.jsf?faces-redirect=true";
	}
	
} 
