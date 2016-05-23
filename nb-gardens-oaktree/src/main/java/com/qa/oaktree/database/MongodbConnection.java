package com.qa.oaktree.database;

import java.util.List;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongodbConnection 
{
	static Mongo mongo = new Mongo("Student14", 27017);
	//DB db = mongoClient.getDB ("products");
	//boolean auth = db.authenticate("Stephen", "rockstar".toCharArray());
	
	
	public static void main (String[] args)
	{
		List<String> dbs = mongo.getDatabaseNames();
		for (String db : dbs)
		{
			System.out.println(db);
		}
	}
}


