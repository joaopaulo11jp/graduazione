package br.edu.ifpb.pweb2.procmanager.bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;
import br.edu.ifpb.pweb2.procmanager.dao.DAOProfessor;
import br.edu.ifpb.pweb2.procmanager.dao.DAOTipoDefesa;
import br.edu.ifpb.pweb2.procmanager.dao.DAOUsuario;
import br.edu.ifpb.pweb2.procmanager.model.Professor;
import br.edu.ifpb.pweb2.procmanager.model.TipoDefesa;
import br.edu.ifpb.pweb2.procmanager.model.Usuario;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
public class ContextoListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextoListener() {
        // TODO Auto-generated constructor stub
    }

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		DAOConcluinte daoc = new DAOConcluinte();
		DAOTipoDefesa daoTipoDefesa = new DAOTipoDefesa();
		System.out.println("Foi");
		System.out.println("Foi no listener!");
		
		DAOUsuario daoU = new DAOUsuario();
		DAOProfessor daoP = new DAOProfessor();
		
		if(daoU.readAll().size() == 0){
			
			daoP.begin();
			daoP.create(new Professor("Professor Teste"));
			daoP.commit();
			
			daoU.begin(); 
			System.out.println("Não há usuário existentes, criar admin ( RETIRAR ISTO DPS )");
						
			daoU.create(new Usuario("admin","senhaplana",daoP.read(1),true));
			
			daoTipoDefesa.create(new TipoDefesa("ESTAGIO"));
			daoTipoDefesa.create(new TipoDefesa("EXTENSAO"));
			daoTipoDefesa.create(new TipoDefesa("PESQUISA"));
			
			daoP.create(new Professor("Professor Teste 2"));
			daoP.create(new Professor("Professor Teste 3"));
			daoU.commit();
			
			System.out.println("Usuario e professor criados !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		
	}
	
}
