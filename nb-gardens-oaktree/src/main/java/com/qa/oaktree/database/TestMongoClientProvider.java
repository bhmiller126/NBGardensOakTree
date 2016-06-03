package com.qa.oaktree.database;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mongodb.*;

@Stateless
public class TestMongoClientProvider {

@EJB
static
MongoClientProvider mongoClientProvider = new MongoClientProvider();

public static void main(String[] args)
{
	//getCollectionNames(); 
	DB db = mongoClientProvider.getMongoClient().getDB("products");
	DBCollection collection = db.getCollection("product");
	showActiveProducts(collection);
}

public static Set<String> getCollectionNames(){

//MongoClient mongoClient = mongoClientProvider.getMongoClient();

@SuppressWarnings("deprecation")
DB db = mongoClientProvider.getMongoClient().getDB("products");
Set<String> colls = db.getCollectionNames();

for (String s : colls) {
    System.out.println(s);
}

return colls;
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
}


