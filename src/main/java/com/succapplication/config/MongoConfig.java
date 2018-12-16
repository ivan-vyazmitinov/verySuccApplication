package com.succapplication.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@PropertySource("classpath:config.properties")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongodb.url}")
    private String mongodbUrl;

    @Value("${mongodb.port}")
    private int mongodbPort;

    @Value("${mongodb.db}")
    private String defaultDb;

    @Override
    protected String getDatabaseName() {
        return defaultDb;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongodbUrl, mongodbPort);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), defaultDb);
    }
}
