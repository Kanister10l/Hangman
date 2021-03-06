package com.mygdx.hangman;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Random;


public class WordLoader {
    double points;
    Word word;
    MongoCollection<Document> connection;

    public WordLoader() {
        loadCollection();
    }

    public WordLoader(double points) {
        this.points = points;
        loadCollection();
    }

    private void loadCollection() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://app:appapp1@ds047955.mlab.com:47955/wisielec"));
        MongoDatabase database = mongoClient.getDatabase("wisielec");
        connection = database.getCollection("words");
    }

    public void loadWord() {
        Random generator = new Random();
        Document or1 = new Document("$and", Arrays.asList(new Document("points", new Document("$lt", points)), new Document("points", new Document("$gt", points - 2))));
        Document or2 = new Document("$and", Arrays.asList(new Document("points", new Document("$gt", points)), new Document("points", new Document("$lt", points + 2))));
        Document match = new Document("$match", new Document("$or",
                Arrays.asList(or1, or2)
        ));
        Document sample = new Document("$sample", new Document("size", 1));
        Document limit = new Document("$limit", 5000);
        Document sort = new Document("$sort", new Document("points", 1));
        Document loadedWord = connection.aggregate(Arrays.asList(match, limit, sort, sample)).first();
        word = new Word(loadedWord.getString("word"), loadedWord.getDouble("points"));
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Word getWord() {
        return word;
    }
}