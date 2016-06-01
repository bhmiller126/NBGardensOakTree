package com.qa.oaktree.util;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * This will be the bean in charge of managing our database connections
 * 
 * @author Barry
 *
 */
@Singleton
public class PersistanceManager
{
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManager openEntityManager()
	{
		return null;
	}
	
	public void closeEntityManager(EntityManager em)
	{
		
	}
}
