package br.edu.ifpb.pweb2.procmanager.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.procmanager.model.Usuario;

public class DAOUsuario extends DAO<Usuario>{

		public DAOUsuario(){
			super();
		}
		
		
	
	public Usuario readUsuarioByLoginAndSenha(String login, String senha){
		
		Query q = manager.createQuery("select u from Usuario u where u.login = :l AND u.senha = :s");
		q.setParameter("l",login);
		q.setParameter("s",senha);
		
		try{
			Usuario user = (Usuario) q.getSingleResult();
			return user;
		}catch(NoResultException e){
			return null;
		}
		
	}

}