package br.edu.ifpb.pweb2.procmanager.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.pweb2.procmanager.model.Usuario;

@ManagedBean
@SessionScoped
public class SessionBean {
	private Usuario usuario;
	
	
	@PostConstruct
	public void init(){
		
	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public void unloadFlashLogin(){
		System.out.println("unloaflash executado");
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		
		if(this.usuario == null) this.usuario = (Usuario) flash.get("usuario");
	}
}
