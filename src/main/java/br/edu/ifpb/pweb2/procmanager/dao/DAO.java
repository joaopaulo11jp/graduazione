package br.edu.ifpb.pweb2.procmanager.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.*;

public abstract class DAO<T> implements DAOInterface<T>{
	protected static EntityManager manager;

		public DAO(){
			if(manager == null){
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("GRADUAZIONE");
				manager = factory.createEntityManager();
			}
		}

	public static void close(){
		if(manager != null){
			manager.close();
			manager = null;
		}
	}

	public void create(T obj){
		manager.persist(obj);
	}
	
	public T update(T obj){
		manager.merge(obj);
	 return obj;
	}

	public void delete(T obj){
		manager.remove(obj);
	}

	public void refresh(T obj){
		manager.refresh(obj);
	}
//--- transaction
	public static void begin(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}

	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear(); // esvaziar o cache de objetos
		}
	}
	
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}

	@SuppressWarnings("unchecked")
	public T read(Object chave){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
		.getGenericSuperclass()).getActualTypeArguments()[0];
	 return manager.find(type, chave);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
		.getGenericSuperclass()).getActualTypeArguments()[0];

		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
     return (List<T>) query.getResultList();
	}
}