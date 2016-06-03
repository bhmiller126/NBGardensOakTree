package com.qa.example.util;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * This will be the bean in charge of managing our database connections.
 * 
 * @author James Thompson
 */
@Singleton
public class PersistanceManager {
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManager openEntityManager() {
		//TODO
		return null;
	}
	
	public void closeEntityManager(EntityManager em) {
		//TODO
	}
}