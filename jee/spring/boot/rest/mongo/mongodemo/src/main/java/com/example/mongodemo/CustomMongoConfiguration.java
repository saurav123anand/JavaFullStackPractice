package com.example.mongodemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class CustomMongoConfiguration extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongo.database}")
    private String database;
    @Override
    protected String getDatabaseName() {
        return database;
    }
}
