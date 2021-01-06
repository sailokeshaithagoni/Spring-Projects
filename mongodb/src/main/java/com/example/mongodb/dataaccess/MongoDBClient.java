package com.example.mongodb.dataaccess;

import com.mongodb.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class MongoDBClient {

    public static String getDbConnection()
    {
        try {
            String connectionString = System.getProperty("mongodb.uri");
            MongoClientURI uri = new MongoClientURI(connectionString);
            MongoClient mongoClient = new MongoClient(uri);
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
            /*DB mongodb = (DB) mongoClient.getDatabase("MongoDbDemo");
            DBCollection dbCollection = mongodb.getCollection("DemoCollection");
            DBObject dbObject = new BasicDBObject("FirstName", "Sailokesh").append("No", "17634628754");
            dbCollection.insert(dbObject);
            DBCursor dbCursor=dbCollection.find(new BasicDBObject("FirstName", "Sailokesh"));
            System.out.println(dbCursor.one());
            return dbCursor.one().toString();*/
            return "";
        }
        catch (Exception exception)
        {
            System.out.println("Details ---->"+exception.getMessage());
            return null;
        }
    }
}
