package br.edu.ifpb.pweb2.procmanager.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.procmanager.model.Concluinte;
import br.edu.ifpb.pweb2.procmanager.model.Usuario;

public class DAOConcluinte extends DAO<Concluinte>{

		public DAOConcluinte(){
			super();
		}
		
	
	public Concluinte readById(String matricula){
		Query q = manager.createQuery("select c from Concluinte c where c.matricula = :m");
		q.setParameter("m",matricula);
		
		try{
			Concluinte concluinte = (Concluinte) q.getSingleResult();
			return concluinte;
		}catch(NoResultException e){
			return null;
		}
		
	}

}