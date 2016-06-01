package com.qa.oaktree.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongodbConnection 
{	
	@SuppressWarnings({ "resource", "deprecation" })
	public static void main (String[] args) 
	{			
		MongoClient mongo = new MongoClient(new ServerAddress("192.168.1.5", 27017));
		DB db = mongo.getDB("products");
		DBCollection collection = db.getCollection("product");
		showOutdoorLiving(collection);
		//selectAllRecordsFromCollection(collection);
		
		//MongoClient mongo = new MongoClient(new ServerAddress("192.168.1.5", 27017));
		//MongoCredential credential = MongoCredential.createMongoCRCredential("Stephen", "admin", "rockstar".toCharArray());
		//MongoClient mongoClient = new MongoClient(new ServerAddress("192.168.1.5", 27017), Arrays.asList(credential));		
		/*
		DB db = mongoClient.getDB("products");
		DBCollection table = db.getCollection("products");
		BasicDBObject searchQuery = new BasicDBObject();		
		searchQuery.put("product_status", "Active");
		DBCursor cursor = table.find(searchQuery);
		System.out.println(cursor);
		*/		
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
	
	private static void closeMongoConnection()
	{
		
	}
}


