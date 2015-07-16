package br.edu.ifpb.pweb2.procmanager.bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.edu.ifpb.pweb2.procmanager.dao.DAOConcluinte;
import br.edu.ifpb.pweb2.procmanager.dao.DAOProfessor;
import br.edu.ifpb.pweb2.procmanager.dao.DAOSituacao;
import br.edu.ifpb.pweb2.procmanager.dao.DAOTipoDefesa;
import br.edu.ifpb.pweb2.procmanager.dao.DAOTipoPendencia;
import br.edu.ifpb.pweb2.procmanager.dao.DAOUsuario;
import br.edu.ifpb.pweb2.procmanager.model.Professor;
import br.edu.ifpb.pweb2.procmanager.model.Situacao;
import br.edu.ifpb.pweb2.procmanager.model.TipoDefesa;
import br.edu.ifpb.pweb2.procmanager.model.TipoPendencia;
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
		DAOSituacao daoS = new DAOSituacao();
		DAOTipoDefesa daoTipoDefesa = new DAOTipoDefesa();
		DAOTipoPendencia daoTp = new DAOTipoPendencia();

		DAOUsuario daoU = new DAOUsuario();
		DAOProfessor daoP = new DAOProfessor();
		
		if(daoU.readAll().size() == 0){
			
			daoP.begin();
			daoP.create(new Professor("Professor Teste"));
			daoP.commit();
			
			daoU.begin(); 
						
			daoU.create(new Usuario("admin","senhaplana",daoP.read(1),true));
			
			daoTipoDefesa.create(new TipoDefesa("ESTAGIO"));
			daoTipoDefesa.create(new TipoDefesa("EXTENSAO"));
			daoTipoDefesa.create(new TipoDefesa("PESQUISA"));
			
			daoP.create(new Professor("Professor Teste 2"));
			daoP.create(new Professor("Professor Teste 3"));
			
			daoS.create(new Situacao("Chegou �s m�os do coordenador",1));
			daoS.create(new Situacao("Enviou ao orientador",2));
			daoS.create(new Situacao("Recebeu do orientador",3));
			daoS.create(new Situacao("Enviou � Coordena��o de est�gio",4));
			daoS.create(new Situacao("Aguardando resposta da Coordena��o de Est�gio",5));
			daoS.create(new Situacao("Confirmado pela Coordena��o de Est�gio",6));
			
			
			daoTp.create(new TipoPendencia("Carga hor�ria"));
			daoTp.create(new TipoPendencia("ENADE"));
			daoTp.create(new TipoPendencia("Atividades Complementares"));
			daoTp.create(new TipoPendencia("Processo de est�gio"));
			daoTp.create(new TipoPendencia("Documenta��o"));
			daoTp.create(new TipoPendencia("Semestres"));
			
			daoU.commit();
			
			
		}
		
	}
	
}
