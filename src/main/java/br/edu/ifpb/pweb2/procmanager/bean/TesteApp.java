package br.edu.ifpb.pweb2.procmanager.bean;


import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;

@ManagedBean(eager=true)
@ApplicationScoped

public class TesteApp {

	@PostConstruct
	public void init(){
//		DAOConcluinte daoc = new DAOConcluinte();
//		System.out.println("Foi");
//		System.out.println("No ApplicationScoped!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
}
