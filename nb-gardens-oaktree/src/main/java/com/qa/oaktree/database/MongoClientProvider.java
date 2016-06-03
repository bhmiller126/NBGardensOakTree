package com.qa.oaktree.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class MongoClientProvider
{	
	private final String mongoIpAddress = "192.168.1.5";
	private final Integer mongoPortNumber = 28018;
	private MongoClient mongoClient = null;
	
	public MongoClientProvider()
	{
		try {
			init();
			}
		catch (UnknownHostException e)
		{
			System.err.println("Mongo is not active");
			e.printStackTrace();
		}
	}
	
	@Lock(LockType.READ)
	public MongoClient getMongoClient()
		{
			return mongoClient;
		}
	
	@PostConstruct
	public void init () throws UnknownHostException
	{	
		mongoClient = new MongoClient(new ServerAddress(mongoIpAddress, mongoPortNumber));
	}
	
	
	
	
	
	
	
	
	private static void showActiveProducts(DBCollection collection)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("product_status", "Active");
		
		DBCursor cursor = collection.find(whereQuery, whereQuery);
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}
	
	private static void showFurniture(DBCollection collection)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("product_category", "Furniture");
		
		DBCursor cursor = collection.find(whereQuery, whereQuery);
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}
	
	private static void showDecor(DBCollection collection)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("product_category", "Decor");
		
		DBCursor cursor = collection.find(whereQuery, whereQuery);
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}
	
	private static void showDIYTools(DBCollection collection)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("product_category", "Power Tool");
		
		DBCursor cursor = collection.find(whereQuery, whereQuery);
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}

	}
	
	private static void showOutdoorLiving(DBCollection collection)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("product_category", "Outdoor Living");
		
		DBCursor cursor = collection.find(whereQuery, whereQuery);
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}

	}
	
	private static void showClearance(DBCollection collection)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("product_category", "Clearance");
		
		DBCursor cursor = collection.find(whereQuery, whereQuery);
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}

	}
	
	private static void selectAllRecordsFromCollection(DBCollection collection)
	{
		DBCursor cursor = collection.find();
		while(cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}
}


