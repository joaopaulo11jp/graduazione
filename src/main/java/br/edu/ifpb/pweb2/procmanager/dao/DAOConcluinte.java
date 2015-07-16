package br.edu.ifpb.pweb2.procmanager.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.procmanager.model.Concluinte;

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

	public List<Concluinte> readAllConcluinteWithoutProcess(){
		Query q = manager.createQuery("select c from Concluinte c where c.processoEstagio = null");
		
		
		try{
			List<Concluinte> concluintes = q.getResultList();
			return concluintes;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Concluinte> readAllConcluiteWithPendencias(){
		Query q = manager.createQuery("select c from Concluinte c where c.pendencias IS NOT EMPTY");
		
		
		try{
			List<Concluinte> concluintes = q.getResultList();
			return concluintes;
		}catch(NoResultException e){
			return null;
		}
	}
}