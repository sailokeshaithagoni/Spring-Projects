package com.mylogic.springdemo.dataaccess;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.bson.Document;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class ClientMongoDB {
    private static final Logger log = LoggerFactory.getLogger(ClientMongoDB.class);
    private static final Random rand = new Random();
    public static String getDbConnection()
    {
        try {
            String connectionString = System.getProperty("mongodb.uri");
            MongoClientURI uri = new MongoClientURI(connectionString);
            MongoClient mongoClient = new MongoClient(uri);
            /*List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson())); */
            MongoDatabase mongodb = mongoClient.getDatabase("MongoDbDemo");
            MongoCollection dbCollection = mongodb.getCollection("DemoCollection");
            //DBObject dbObject = new BasicDBObject("FirstName", "Sailokesh").append("No", "17634628754");
            MongoCollection<Document> gradesCollection=mongodb.getCollection("DemoCollection");;
            /*gradesCollection.insertOne(generateNewGrade(10000d, 1d));
            dbCollection.insertOne(gradesCollection);*/
            long temp=gradesCollection.countDocuments();
            System.out.println("Count");
            System.out.println(temp);
            LinkedList<String> ll=new LinkedList<String>();
            return "It worked";
        }
        catch (Exception exception)
        {
            log.error(exception.getMessage());
            return null;
        }
    }
    private static Document generateNewGrade(double studentId, double classId) {
        List<Document> scores = asList(new Document("type", "exam").append("score", rand.nextDouble() * 100),
                new Document("type", "quiz").append("score", rand.nextDouble() * 100),
                new Document("type", "homework").append("score", rand.nextDouble() * 100),
                new Document("type", "homework").append("score", rand.nextDouble() * 100));
        return new Document("_id", new ObjectId()).append("student_id", studentId)
                .append("class_id", classId)
                .append("scores", scores);
    }
}
