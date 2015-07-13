package br.edu.ifpb.pweb2.procmanager.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.pweb2.procmanager.dao.DAOUsuario;
import br.edu.ifpb.pweb2.procmanager.model.Usuario;


@ManagedBean
@RequestScoped
public class LoginServiceBean{
	private String login;
	private String senha;
	//continua no próximo episódio :)

	public String getLogin(){
		return this.login;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getSenha(){
		return this.senha;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public String fazerLogin(){
		DAOUsuario daoU = new DAOUsuario();
		Usuario usuario = daoU.readUsuarioByLoginAndSenha(this.login, this.senha);
		
		if(usuario != null){
			System.out.println("localizou o usuario: "+usuario.getLogin());
			System.out.println("Professor: "+usuario.getProfessor().getNome());
			this.loadFlashLogin(usuario);
			return "checaLogin.jsf";
		}else{
			System.out.println("Nao encontrou usuario e retornou nulo");
			this.addMessage("Falha ao efetuar login","Login ou senha inválidos!");
			return null;
		}
    }
	
	public void addMessage(String summary, String detail){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void loadFlashLogin(Usuario usuario){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("usuario",usuario);
	}

}