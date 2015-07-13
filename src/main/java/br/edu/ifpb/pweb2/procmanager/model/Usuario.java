package br.edu.ifpb.pweb2.procmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String login;
	private String senha;
	@OneToOne
	private Professor professor;
	private boolean coordenadorCurso;
	
		public Usuario(String login, String senha, Professor professor,
				boolean coordenadorCurso) {
			this.login = login;
			this.senha = senha;
			this.professor = professor;
			this.coordenadorCurso = coordenadorCurso;
		}
		
		public Usuario(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public boolean isCoordenadorCurso() {
		return coordenadorCurso;
	}

	public void setCoordenadorCurso(boolean coordenadorCurso) {
		this.coordenadorCurso = coordenadorCurso;
	}
	
}
