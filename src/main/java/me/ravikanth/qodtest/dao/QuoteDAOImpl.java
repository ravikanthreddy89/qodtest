package me.ravikanth.qodtest.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import me.ravikanth.qodtest.resource.Quote;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ragudipati on 11/30/15.
 */
public class QuoteDAOImpl implements QuoteDAO {
    public Quote insert(Quote quote) {

        Quote ret = null;
        MongoClient mongoClient = null;
        try{
            // Connect to MongoDB
            mongoClient = new MongoClient("localhost", 27017);
            DB db = (DB) mongoClient.getDB("qod");
            DBCollection dbCollection =  db.getCollection("qod_unused");

            BasicDBObject doc = new BasicDBObject();
            for(String key : quote.getFields().keySet()){
                doc.append(key, quote.getFields().get(key));
            }
            dbCollection.insert(doc);
            mongoClient.close();
            ret = quote;
        }catch (Exception e){
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }finally {
            if(mongoClient != null){
                mongoClient.close();
            }
        }
        return ret;
    }

    public Quote getQuote() {
        Quote ret = null;
        MongoClient mongoClient = null;

        try{
            mongoClient = new MongoClient("localhost", 27017);
            DB db = (DB) mongoClient.getDB("qod");
            DBCollection unusedDBCollection = (DBCollection) db.getCollection("qod_unused");
            DBCollection usedDBCollection = (DBCollection) db.getCollection("qod_used");

            BasicDBObject doc = (BasicDBObject) unusedDBCollection.findOne();

            ret = new Quote();
            Map<String, String> fields = new HashMap<String , String>();

            for(Map.Entry<String, Object> entry : doc.entrySet()){
                if(!entry.getKey().contains("_id"))
                fields.put(entry.getKey(), (String) entry.getValue());
            }
            ret.setFields(fields);

            unusedDBCollection.remove(doc);
            usedDBCollection.insert(doc);
            mongoClient.close();

        }catch(Exception e){
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }finally {
            if(mongoClient != null){
                mongoClient.close();
            }
        }
        return ret;
    }
}
