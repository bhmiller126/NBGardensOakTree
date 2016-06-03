package com.qa.oaktree.util;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * This will be the bean in charge of managing our database connections
 * 
 * @author Angus
 *
 */
@Singleton
public class PersistanceManager
{
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManager openEntityManager()
	{
		return entityManagerFactory.createEntityManager();
	}
	
	public void closeEntityManager(EntityManager em)
	{
		em.close();
	}
}
