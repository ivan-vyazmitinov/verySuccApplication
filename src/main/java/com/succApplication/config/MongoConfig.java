package com.succApplication.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig  extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "succMongoDB";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }

}
