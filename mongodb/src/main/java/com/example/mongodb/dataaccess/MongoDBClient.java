package com.example.mongodb.dataaccess;

import com.mongodb.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class MongoDBClient {

    public static String getDbConnection()
    {
        try {
            MongoClientURI uri = new MongoClientURI(
                    "mongodb+srv://sailokesh:rsTFxMAu5UHpOacL@cluster0.c8xds.mongodb.net/MongoDbDemo?retryWrites=true&w=majority");
            MongoClient mongoClient = new MongoClient(uri);
            DB mongodb = (DB) mongoClient.getDatabase("MongoDbDemo");
            DBCollection dbCollection = mongodb.getCollection("DemoCollection");
            DBObject dbObject = new BasicDBObject("FirstName", "Sailokesh").append("No", "17634628754");
            dbCollection.insert(dbObject);
            DBCursor dbCursor=dbCollection.find(new BasicDBObject("FirstName", "Sailokesh"));
            System.out.println(dbCursor.one());
            return dbCursor.one().toString();
        }
        catch (Exception exception)
        {
            System.out.println("Details ---->"+exception.getMessage());
            return null;
        }
    }
}
